package ru.threedisevenzeror.datatree.typed.number;

import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.ValueFunction;
import ru.threedisevenzeror.datatree.typed.BooleanValue;
import ru.threedisevenzeror.datatree.typed.ObjectValue;

import java.math.BigDecimal;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

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

    public IntegerValue compareTo(Value<? extends Number> otherValue) {

        return new IntegerValue(new ValueFunction<>(getWrappedValue(), v -> {
            Number otherNumber = otherValue.get();
            if(v != null) {
                if(otherNumber != null) {

                    if(otherNumber instanceof Integer) {
                        return Integer.compare(v.intValue(), otherNumber.intValue());
                    } else if(otherNumber instanceof Float) {
                        return Float.compare(v.floatValue(), otherNumber.floatValue());
                    } else if(otherNumber instanceof Long) {
                        return Long.compare(v.longValue(), otherNumber.longValue());
                    } else if(otherNumber instanceof Double) {
                        return Double.compare(v.doubleValue(), otherNumber.doubleValue());
                    } else if(otherNumber instanceof Short) {
                        return Short.compare(v.shortValue(), otherNumber.shortValue());
                    } else if(otherNumber instanceof Byte) {
                        return Byte.compare(v.byteValue(), otherNumber.byteValue());
                    } else {
                        // TODO: Уродливое и непроизводительное решение
                        // Придумать каким образом можно сравнивать два числа
                        return new BigDecimal(v.toString()).compareTo(new BigDecimal(otherNumber.toString()));
                    }
                } else {
                    return 1;
                }
            } else {
                if(otherNumber != null) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }));
    }

    public BooleanValue greaterThan(Value<? extends Number> otherValue) {
        return new BooleanValue(new ValueFunction<>(compareTo(otherValue).getWrappedValue(), v -> v > 0));
    }

    public BooleanValue greaterThanOrEquals(Value<? extends Number> otherValue) {
        return new BooleanValue(new ValueFunction<>(compareTo(otherValue).getWrappedValue(), v -> v >= 0));
    }

    public BooleanValue lessThan(Value<? extends Number> otherValue) {
        return new BooleanValue(new ValueFunction<>(compareTo(otherValue).getWrappedValue(), v -> v < 0));
    }

    public BooleanValue lessThanOrEquals(Value<? extends Number> otherValue) {
        return new BooleanValue(new ValueFunction<>(compareTo(otherValue).getWrappedValue(), v -> v <= 0));
    }

    @Override
    public NumberValue<T> debounce(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new NumberValue<>(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public NumberValue<T> debounce(Executor executor, TimeUnit timeUnit, long time) {
        return new NumberValue<>(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public NumberValue<T> delay(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new NumberValue<>(super.delay(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public NumberValue<T> delay(Executor executor, TimeUnit timeUnit, long time) {
        return new NumberValue<>(super.delay(executor, timeUnit, time).getWrappedValue());
    }
}
