package ru.threedisevenzeror.datatree.base;

import java.util.function.Function;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class ValueFunction<F, T> extends AbstractDependentValue<T, Object> {

    private Value<F> value;
    private Function<F, T> function;

    public ValueFunction(Value<F> value, Function<F, T> function) {
        this.value = value;
        this.function = function;
        addDependentValue(value);
    }

    @Override
    public void addDependentValue(Value<?> value) {
        super.addDependentValue(value);
    }

    @Override
    public void removeDependentValue(Value<?> value) {
        super.removeDependentValue(value);
    }

    @Override
    protected T getNewValue() {
        return function.apply(value.get());
    }
}
