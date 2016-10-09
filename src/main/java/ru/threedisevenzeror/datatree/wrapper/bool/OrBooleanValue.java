package ru.threedisevenzeror.datatree.wrapper.bool;

import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.functional.ValueSupplier;

import java.util.List;

/**
 * Created by ThreeDISevenZeroR on 08.10.2016.
 */
public class OrBooleanValue extends BooleanValue {

    @SafeVarargs
    public OrBooleanValue(Value<Boolean>... args) {
        ValueSupplier<Boolean> supplier = new ValueSupplier<>(() -> {
            for(Value<Boolean> arg : args) {
                Boolean b = arg.get();
                if(b != null && b) {
                    return true;
                }
            }
            return false;
        });

        for(Value<Boolean> v : args) {
            supplier.addDependentValue(v);
        }

        setWrappedValue(supplier);
    }

    @Override
    public BooleanValue or(Value<Boolean> value) {
        List<Value<? extends Boolean>> currentValues = getDependentValues();
        Value<Boolean>[] args = new Value[currentValues.size() + 1];
        currentValues.toArray(args);
        args[args.length - 1] = value;
        return new OrBooleanValue(args);
    }
}
