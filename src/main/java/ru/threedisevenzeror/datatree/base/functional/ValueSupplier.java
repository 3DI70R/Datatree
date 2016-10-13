package ru.threedisevenzeror.datatree.base.functional;

import ru.threedisevenzeror.datatree.base.AbstractDependentValue;
import ru.threedisevenzeror.datatree.base.OnValueChangedListener;
import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.wrapper.text.StringValue;

import java.util.List;
import java.util.function.Supplier;

/**
 * Created by ThreeDISevenZeroR on 08.10.2016.
 */
public class ValueSupplier<T> extends AbstractDependentValue<T, Object> {

    private Supplier<T> supplier;
    private String name;

    public ValueSupplier(String name, Supplier<T> supplier) {
        this.supplier = supplier;
        this.name = name;
    }

    public ValueSupplier(String name, Supplier<T> supplier, Value<?>... dependentValues) {
        this.supplier = supplier;
        this.name = name;

        for(Value<?> v : dependentValues) {
            addDependentValue(v);
        }
    }

    @Override
    protected T getNewValue() {
        return supplier.get();
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
    public String toString() {
        return name + " -> " + get();
    }
}
