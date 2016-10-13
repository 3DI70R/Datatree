package ru.threedisevenzeror.datatree.logical;

import ru.threedisevenzeror.datatree.base.AbstractDependentValue;
import ru.threedisevenzeror.datatree.base.Value;

import java.util.concurrent.Executor;

/**
 * Created by ThreeDISevenZeroR on 13.10.2016.
 */
public class UpdateOnAnotherThreadValue <T> extends AbstractDependentValue<T, Object> {

    private T currentValue;
    private Value<T> value;
    private Value<? extends Executor> updateExecutor;

    public UpdateOnAnotherThreadValue(Value<T> value, Value<? extends Executor> updateExecutor) {
        this.currentValue = value.get();
        this.value = value;
        this.updateExecutor = updateExecutor;

        addDependentValue(value);
        addDependentValue(updateExecutor);
    }

    @Override
    protected T getNewValue() {
        return currentValue;
    }

    @Override
    protected void onDependentValueUpdated() {
        T newValue = value.get();
        updateExecutor.get().execute(() -> {
            currentValue = newValue;
            updateValue();
        });
    }
}
