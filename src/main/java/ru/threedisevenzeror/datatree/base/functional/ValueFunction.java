package ru.threedisevenzeror.datatree.base.functional;

import ru.threedisevenzeror.datatree.base.AbstractDependentValue;
import ru.threedisevenzeror.datatree.base.Value;

import java.util.function.Function;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class ValueFunction<F, T> extends AbstractDependentValue<T, Object> {

    private Value<F> value;
    private Function<F, T> function;
    private String name;

    public ValueFunction(Value<F> value, Function<F, T> function) {
        this("unnamed function", value, function);
    }

    public ValueFunction(String name, Value<F> value, Function<F, T> function) {
        this.name = name;
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

    @Override
    public String toString() {
        return name + " -> " + super.toString();
    }
}
