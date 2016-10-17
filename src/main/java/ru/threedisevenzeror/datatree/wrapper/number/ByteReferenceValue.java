package ru.threedisevenzeror.datatree.wrapper.number;

import ru.threedisevenzeror.datatree.base.ReferenceValue;
import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.wrapper.text.StringValue;

public class ByteReferenceValue<V extends Value<Byte>>
        extends ByteValue implements ReferenceValue<V, Byte> {

    public ByteReferenceValue() {
        this(null);
    }

    public ByteReferenceValue(V value) {
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