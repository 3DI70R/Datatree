package ru.threedisevenzeror.datatree.wrapper;

import ru.threedisevenzeror.datatree.base.ReferenceValue;
import ru.threedisevenzeror.datatree.base.Value;

public class ObjectReferenceValue<T, V extends Value<T>>
        extends ObjectValue<T> implements ReferenceValue<V, T> {

    public ObjectReferenceValue() {
        this(null);
    }

    public ObjectReferenceValue(V value) {
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