package ru.threedisevenzeror.datatree.wrapper.number;

import ru.threedisevenzeror.datatree.base.ReferenceValue;
import ru.threedisevenzeror.datatree.base.Value;

public class IntegerReferenceValue<V extends Value<Integer>>
        extends IntegerValue implements ReferenceValue<V, Integer> {

    public IntegerReferenceValue() {
        this(null);
    }

    public IntegerReferenceValue(V value) {
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