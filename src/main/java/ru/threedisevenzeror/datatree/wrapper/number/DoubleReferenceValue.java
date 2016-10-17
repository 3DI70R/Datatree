package ru.threedisevenzeror.datatree.wrapper.number;

import ru.threedisevenzeror.datatree.base.ReferenceValue;
import ru.threedisevenzeror.datatree.base.Value;

public class DoubleReferenceValue<V extends Value<Double>>
        extends DoubleValue implements ReferenceValue<V, Double> {

    public DoubleReferenceValue() {
        this(null);
    }

    public DoubleReferenceValue(V value) {
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