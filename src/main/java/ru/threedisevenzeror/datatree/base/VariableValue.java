package ru.threedisevenzeror.datatree.base;

import java.util.Objects;

/**
 * Created by ThreeDISevenZeroR on 07.10.16.
 */
public class VariableValue<T> extends AbstractMutableValue<T> {

    private T value;

    public VariableValue() {
    }

    public VariableValue(T value) {
        this.value = value;
    }

    @Override
    public T get() {
        return value;
    }

    public void set(T newValue) {
        if(!Objects.equals(value, newValue)) {
            T oldValue = this.value;
            this.value = newValue;
            notifyListeners(oldValue, value);
        }
    }
}
