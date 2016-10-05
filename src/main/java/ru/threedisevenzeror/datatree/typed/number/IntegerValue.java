package ru.threedisevenzeror.datatree.typed.number;

import ru.threedisevenzeror.datatree.base.Value;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class IntegerValue extends NumberValue<Integer> {

    public IntegerValue(Value<Integer> value) {
        super(value);
    }

    @Override
    public IntegerValue asInteger() {
        return this;
    }
}
