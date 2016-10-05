package ru.threedisevenzeror.datatree.typed.number;

import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.ValueFunction;
import ru.threedisevenzeror.datatree.typed.ObjectValue;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class NumberValue<T extends Number> extends ObjectValue<T> {

    public NumberValue(Value<T> value) {
        super(value);
    }

    public ByteValue asByte() {
        return new ByteValue(new ValueFunction<>(getWrappedValue(), v -> v != null ? v.byteValue() : null));
    }

    public ShortValue asShort() {
        return new ShortValue(new ValueFunction<>(getWrappedValue(), v -> v != null ? v.shortValue() : null));
    }

    public IntegerValue asInteger() {
        return new IntegerValue(new ValueFunction<>(getWrappedValue(), v -> v != null ? v.intValue() : null));
    }

    public LongValue asLong() {
        return new LongValue(new ValueFunction<>(getWrappedValue(), v -> v != null ? v.longValue() : null));
    }

    public FloatValue asFloat() {
        return new FloatValue(new ValueFunction<>(getWrappedValue(), v -> v != null ? v.floatValue() : null));
    }

    public DoubleValue asDouble() {
        return new DoubleValue(new ValueFunction<>(getWrappedValue(), v -> v != null ? v.doubleValue() : null));
    }
}
