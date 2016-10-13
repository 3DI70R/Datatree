package ru.threedisevenzeror.datatree.wrapper.bool;

import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.functional.ValueSupplier;

import java.util.List;

/**
 * Created by ThreeDISevenZeroR on 08.10.2016.
 */
public class AndBooleanValue extends BooleanValue {

    @SafeVarargs
    public AndBooleanValue(Value<Boolean>... args) {
        setWrappedValue(Value.zip(args, (v) -> {
            for(Boolean arg : v) {
                if(arg == null || !arg) {
                    return false;
                }
            }
            return true;
        }));
    }

    @Override
    protected void updateValue() {
        super.updateValue();
    }

    @Override
    public BooleanValue and(Value<Boolean> value) {
        List<Value<? extends Boolean>> currentValues = getDependentValues();
        Value<Boolean>[] args = new Value[currentValues.size() + 1];
        currentValues.toArray(args);
        args[args.length - 1] = value;
        return new AndBooleanValue(args);
    }
}
