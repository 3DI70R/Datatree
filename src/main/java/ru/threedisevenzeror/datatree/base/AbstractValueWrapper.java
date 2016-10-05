package ru.threedisevenzeror.datatree.base;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class AbstractValueWrapper<T> extends AbstractDependentValue<T, T> {

    private Value<T> wrappedValue;

    public AbstractValueWrapper(Value<T> value) {
        this.wrappedValue = value;
        addDependentValue(value);
    }

    @Override
    protected T getNewValue() {
        return wrappedValue.get();
    }

    public Value<T> getWrappedValue() {
        return wrappedValue;
    }
}
