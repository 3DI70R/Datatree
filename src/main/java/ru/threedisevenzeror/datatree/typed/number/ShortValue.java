package ru.threedisevenzeror.datatree.typed.number;

import ru.threedisevenzeror.datatree.base.Value;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class ShortValue extends NumberValue<Short> {

    public ShortValue(Value<Short> value) {
        super(value);
    }

    @Override
    public ShortValue asShort() {
        return this;
    }
}
