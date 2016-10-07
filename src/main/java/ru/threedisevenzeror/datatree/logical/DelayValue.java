package ru.threedisevenzeror.datatree.logical;

import ru.threedisevenzeror.datatree.base.AbstractDependentValue;
import ru.threedisevenzeror.datatree.base.Value;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThreeDISevenZeroR on 07.10.16.
 */
public class DelayValue<T> extends AbstractDependentValue<T, T> {

    private static ScheduledThreadPoolExecutor delayExecutor = new ScheduledThreadPoolExecutor(1);

    private T currentValue;
    private Value<T> value;
    private Value<? extends Executor> callbackExecutor;
    private Value<TimeUnit> timeUnit;
    private Value<Long> time;

    public DelayValue(Value<T> value, Value<? extends Executor> executor,
                         Value<TimeUnit> timeUnit, Value<Long> time) {
        this.currentValue = value.get();
        this.value = value;
        this.timeUnit = timeUnit;
        this.time = time;
        this.callbackExecutor = executor;

        addDependentValue(value);
    }

    @Override
    protected T getNewValue() {
        return currentValue;
    }

    @Override
    protected void onDependantValueUpdated() {
        T newValue = value.get();
        delayExecutor.schedule((Runnable) () -> {
            callbackExecutor.get().execute(() -> {
                currentValue = newValue;
                updateValue();
            });
        }, time.get(), timeUnit.get());
    }
}
