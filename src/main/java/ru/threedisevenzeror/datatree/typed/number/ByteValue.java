package ru.threedisevenzeror.datatree.typed.number;

import ru.threedisevenzeror.datatree.base.Value;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class ByteValue extends NumberValue<Byte> {

    public ByteValue(Value<Byte> value) {
        super(value);
    }

    @Override
    public ByteValue asByte() {
        return this;
    }
}
