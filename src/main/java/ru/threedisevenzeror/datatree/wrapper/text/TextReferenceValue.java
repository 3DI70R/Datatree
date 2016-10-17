package ru.threedisevenzeror.datatree.wrapper.text;

import ru.threedisevenzeror.datatree.base.ReferenceValue;
import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.wrapper.ObjectValue;

public class TextReferenceValue<T extends CharSequence, V extends Value<T>>
        extends TextValue<T> implements ReferenceValue<V, T> {

    public TextReferenceValue() {
        this(null);
    }

    public TextReferenceValue(V value) {
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