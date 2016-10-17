package ru.threedisevenzeror.datatree.wrapper.number;

import ru.threedisevenzeror.datatree.base.ReferenceValue;
import ru.threedisevenzeror.datatree.base.Value;

public class ShortReferenceValue<V extends Value<Short>>
        extends ShortValue implements ReferenceValue<V, Short> {

    public ShortReferenceValue() {
        this(null);
    }

    public ShortReferenceValue(V value) {
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