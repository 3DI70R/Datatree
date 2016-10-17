package ru.threedisevenzeror.datatree.wrapper.text;

import ru.threedisevenzeror.datatree.base.ReferenceValue;
import ru.threedisevenzeror.datatree.base.Value;

public class StringReferenceValue<V extends Value<String>>
        extends StringValue implements ReferenceValue<V, String> {

    public StringReferenceValue() {
        this(null);
    }

    public StringReferenceValue(V value) {
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