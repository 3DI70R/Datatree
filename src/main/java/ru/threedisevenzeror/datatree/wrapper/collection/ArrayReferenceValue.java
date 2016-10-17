package ru.threedisevenzeror.datatree.wrapper.collection;

import ru.threedisevenzeror.datatree.base.ReferenceValue;
import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.wrapper.text.StringValue;

public class ArrayReferenceValue<T, V extends Value<T[]>>
        extends ArrayValue<T> implements ReferenceValue<V, T[]> {

    public ArrayReferenceValue() {
        this(null);
    }

    public ArrayReferenceValue(V value) {
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