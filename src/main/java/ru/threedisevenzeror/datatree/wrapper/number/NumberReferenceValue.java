package ru.threedisevenzeror.datatree.wrapper.number;

import ru.threedisevenzeror.datatree.base.ReferenceValue;
import ru.threedisevenzeror.datatree.base.Value;

public class NumberReferenceValue<T extends Number, V extends Value<T>>
        extends NumberValue<T> implements ReferenceValue<V, T> {

    public NumberReferenceValue() {
        this(null);
    }

    public NumberReferenceValue(V value) {
        setReference(value);
    }

    @Override
    public void setReference(V value) {
        setWrappedValue(value);
    }

    @Override
    public V getReference() {
        return (V) getWrappedValue();
    }
}