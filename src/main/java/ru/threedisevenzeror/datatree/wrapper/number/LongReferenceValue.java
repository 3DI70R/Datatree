package ru.threedisevenzeror.datatree.wrapper.number;

import ru.threedisevenzeror.datatree.base.ReferenceValue;
import ru.threedisevenzeror.datatree.base.Value;

public class LongReferenceValue<V extends Value<Integer>>
        extends IntegerValue implements ReferenceValue<V, Integer> {

    public LongReferenceValue() {
        this(null);
    }

    public LongReferenceValue(V value) {
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