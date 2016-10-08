package ru.threedisevenzeror.datatree.base;

import java.util.function.Supplier;

/**
 * Created by ThreeDISevenZeroR on 08.10.2016.
 */
public class ValueSupplier<T> implements Value<T> {

    protected Supplier<T> supplier;

    public ValueSupplier(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    @Override
    public T get() {
        return supplier.get();
    }

    @Override
    public void addOnValueChangedListener(OnValueChangedListener<T> listener) {
        // noop
    }

    @Override
    public void removeOnValueChangedListener(OnValueChangedListener<T> listener) {
        // noop
    }

    @Override
    public String toString() {
        return "supplier";
    }
}
