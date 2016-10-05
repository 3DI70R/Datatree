package ru.threedisevenzeror.datatree.typed.number;

import ru.threedisevenzeror.datatree.base.Value;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class LongValue extends NumberValue<Long> {

    public LongValue(Value<Long> value) {
        super(value);
    }

    @Override
    public LongValue asLong() {
        return this;
    }
}
