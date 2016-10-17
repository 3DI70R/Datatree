package ru.threedisevenzeror.datatree.wrapper.collection;

import ru.threedisevenzeror.datatree.base.ReferenceValue;
import ru.threedisevenzeror.datatree.base.Value;

import java.util.List;

public class ListReferenceValue<T, V extends Value<List<T>>>
        extends ListValue<T> implements ReferenceValue<V, List<T>> {

    public ListReferenceValue() {
        this(null);
    }

    public ListReferenceValue(V value) {
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