package ru.threedisevenzeror.datatree.typed;

import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.ValueFunction;
import ru.threedisevenzeror.datatree.typed.number.NumberValue;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class BooleanValue extends ObjectValue<Boolean> {

    public BooleanValue(Value<Boolean> value) {
        super(value);
    }

    public BooleanValue not() {
        return new BooleanValue(new ValueFunction<>(getWrappedValue(), b -> b != null ? !b : null));
    }

    public NumberValue<?> asNumber() {
        return new NumberValue<>(new ValueFunction<>(getWrappedValue(), b -> b != null ? (b ? 1 : 0) : null));
    }
}
