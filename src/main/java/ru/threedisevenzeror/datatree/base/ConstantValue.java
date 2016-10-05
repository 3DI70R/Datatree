package ru.threedisevenzeror.datatree.base;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class ConstantValue<T> extends AbstractValue<T> {

    private T value;

    public ConstantValue(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void addOnValueChangedListener(OnValueChangedListener<T> listener) {
        // noop
    }

    public void removeOnValueChangedListener(OnValueChangedListener<T> listener) {
        // noop
    }
}
