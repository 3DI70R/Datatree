package ru.threedisevenzeror.datatree.wrapper.collection;

import ru.threedisevenzeror.datatree.base.ReferenceValue;
import ru.threedisevenzeror.datatree.base.Value;

import java.util.Map;

public class MapReferenceValue<K, T, V extends Value<Map<K, T>>>
        extends MapValue<K, T> implements ReferenceValue<V, Map<K, T>> {

    public MapReferenceValue() {
        this(null);
    }

    public MapReferenceValue(V value) {
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