package ru.threedisevenzeror.datatree.wrapper.number;

import ru.threedisevenzeror.datatree.base.ReferenceValue;
import ru.threedisevenzeror.datatree.base.Value;

public class FloatReferenceValue<V extends Value<Float>>
        extends FloatValue implements ReferenceValue<V, Float> {

    public FloatReferenceValue() {
        this(null);
    }

    public FloatReferenceValue(V value) {
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