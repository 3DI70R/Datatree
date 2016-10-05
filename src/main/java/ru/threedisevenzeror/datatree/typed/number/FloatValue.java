package ru.threedisevenzeror.datatree.typed.number;

import ru.threedisevenzeror.datatree.base.Value;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class FloatValue extends NumberValue<Float> {

    public FloatValue(Value<Float> value) {
        super(value);
    }

    @Override
    public FloatValue asFloat() {
        return this;
    }
}
