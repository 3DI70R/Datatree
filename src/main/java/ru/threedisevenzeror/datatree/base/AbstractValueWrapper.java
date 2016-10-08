package ru.threedisevenzeror.datatree.base;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class AbstractValueWrapper<T> extends AbstractDependentValue<T, T> {

    private Value<T> wrappedValue;

    public AbstractValueWrapper() {
        setWrappedValue(null);
    }

    public AbstractValueWrapper(Value<T> value) {
        setWrappedValue(value);
    }

    @Override
    protected T getNewValue() {
        if(wrappedValue != null) {
            return wrappedValue.get();
        } else {
            return null;
        }
    }

    public Value<T> getWrappedValue() {
        return wrappedValue;
    }

    protected void setWrappedValue(Value<T> value) {

        if(wrappedValue != null) {
            removeDependentValue(wrappedValue);
        }

        wrappedValue = value;

        if(wrappedValue != null) {
            addDependentValue(wrappedValue);
        }
    }
}
