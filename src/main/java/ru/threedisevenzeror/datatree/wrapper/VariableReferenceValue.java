package ru.threedisevenzeror.datatree.wrapper;

import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.VariableValue;

/**
 * Created by ThreeDISevenZeroR on 17.10.16.
 */
public class VariableReferenceValue<T> extends AbstractReferenceValue<T, VariableValue<T>> {

    public VariableReferenceValue() {
        this((T) null);
    }

    public VariableReferenceValue(T value) {
        setReference(new VariableValue<>(value));
    }

    public VariableReferenceValue(VariableValue<T> value) {
        setReference(value);
    }

    public void setReference(VariableValue<T> value) {
        setWrappedValue(value);
    }

    public VariableValue<T> getReference() {
        return (VariableValue<T>) getWrappedValue();
    }
}
