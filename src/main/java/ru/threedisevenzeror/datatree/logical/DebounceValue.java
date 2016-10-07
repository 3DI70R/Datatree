package ru.threedisevenzeror.datatree.logical;

import ru.threedisevenzeror.datatree.base.AbstractDependentValue;
import ru.threedisevenzeror.datatree.base.Value;

import java.util.concurrent.*;

/**
 * Created by ThreeDISevenZeroR on 07.10.16.
 */
public class DebounceValue<T> extends AbstractDependentValue<T, T> {

    private static ScheduledThreadPoolExecutor callbackExecutor = new ScheduledThreadPoolExecutor(1);

    private T currentValue;
    private ScheduledFuture<?> updateTask;

    private Value<T> value;
    private Value<? extends Executor> executor;
    private Value<TimeUnit> timeUnit;
    private Value<Long> time;

    public DebounceValue(Value<T> value, Value<? extends Executor> executor,
                         Value<TimeUnit> timeUnit, Value<Long> time) {
        this.currentValue = value.get();
        this.value = value;
        this.timeUnit = timeUnit;
        this.time = time;
        this.executor = executor;

        addDependentValue(value);
    }

    @Override
    protected T getNewValue() {
        return currentValue;
    }

    @Override
    protected void onDependantValueUpdated() {

        if(updateTask != null) {
            updateTask.cancel(false);
        }

        updateTask = callbackExecutor.schedule((Runnable) () -> executor.get().execute(() -> {
            currentValue = value.get();
            updateValue();
        }), time.get(), timeUnit.get());
    }
}
