package ru.threedisevenzeror.datatree.wrapper;

import ru.threedisevenzeror.datatree.base.AbstractValueWrapper;
import ru.threedisevenzeror.datatree.base.Value;

/**
 * Created by ThreeDISevenZeroR on 17.10.16.
 */
public class AbstractReferenceValue<T, V extends Value<T>> extends AbstractValueWrapper<T> {

    public AbstractReferenceValue() {
        this(null);
    }

    public AbstractReferenceValue(V value) {
        setReference(value);
    }

    public void setReference(V value) {
        setWrappedValue(value);
    }

    public V getReference() {
        return (V) getWrappedValue();
    }
}
