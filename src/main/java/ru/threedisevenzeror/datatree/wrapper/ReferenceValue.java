package ru.threedisevenzeror.datatree.wrapper;

import ru.threedisevenzeror.datatree.base.AbstractValueWrapper;
import ru.threedisevenzeror.datatree.base.Value;

/**
 * Created by ThreeDISevenZeroR on 17.10.16.
 */
public class ReferenceValue<T> extends AbstractReferenceValue<T, Value<T>> {

    public ReferenceValue() {
        this((T) null);
    }

    public ReferenceValue(T value) {
        this(Value.constant(value));
    }

    public ReferenceValue(Value<T> value) {
        setReference(value);
    }

    public void setReference(Value<T> value) {
        setWrappedValue(value);
    }

    public void set(T value) {
        setReference(Value.constant(value));
    }

    public Value<T> getReference() {
        return getWrappedValue();
    }
}
