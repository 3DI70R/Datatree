package ru.threedisevenzeror.datatree.typed.number;

import ru.threedisevenzeror.datatree.base.Value;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class DoubleValue extends NumberValue<Double> {

    public DoubleValue(Value<Double> value) {
        super(value);
    }

    @Override
    public DoubleValue asDouble() {
        return this;
    }
}
