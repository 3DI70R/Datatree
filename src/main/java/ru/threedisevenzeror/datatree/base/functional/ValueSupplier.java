package ru.threedisevenzeror.datatree.base.functional;

import ru.threedisevenzeror.datatree.base.AbstractDependentValue;
import ru.threedisevenzeror.datatree.base.OnValueChangedListener;
import ru.threedisevenzeror.datatree.base.Value;

import java.util.function.Supplier;

/**
 * Created by ThreeDISevenZeroR on 08.10.2016.
 */
public class ValueSupplier<T> extends AbstractDependentValue<T, Object> {

    protected Supplier<T> supplier;

    public ValueSupplier(Supplier<T> supplier) {
        this.supplier = supplier;
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
        return "supplier";
    }
}
