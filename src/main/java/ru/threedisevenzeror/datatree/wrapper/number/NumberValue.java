package ru.threedisevenzeror.datatree.wrapper.number;

import ru.threedisevenzeror.datatree.base.ConstantValue;
import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.functional.ValueFunction;
import ru.threedisevenzeror.datatree.wrapper.bool.BooleanValue;
import ru.threedisevenzeror.datatree.wrapper.ObjectValue;

import java.math.BigDecimal;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class NumberValue<T extends Number> extends ObjectValue<T> {

    public NumberValue() {

    }

    public NumberValue(T value) {
        super(value);
    }

    public NumberValue(Value<T> value) {
        super(value);
    }

    public ByteValue asByte() {
        return new ByteValue(new ValueFunction<>("asByte", getWrappedValue(),
                v -> v != null ? v.byteValue() : null));
    }

    public ShortValue asShort() {
        return new ShortValue(new ValueFunction<>("asShort", getWrappedValue(),
                v -> v != null ? v.shortValue() : null));
    }

    public IntegerValue asInteger() {
        return new IntegerValue(new ValueFunction<>("asInteger", getWrappedValue(),
                v -> v != null ? v.intValue() : null));
    }

    public LongValue asLong() {
        return new LongValue(new ValueFunction<>("asLong", getWrappedValue(),
                v -> v != null ? v.longValue() : null));
    }

    public FloatValue asFloat() {
        return new FloatValue(new ValueFunction<>("asFloat", getWrappedValue(),
                v -> v != null ? v.floatValue() : null));
    }

    public DoubleValue asDouble() {
        return new DoubleValue(new ValueFunction<>("asDouble", getWrappedValue(),
                v -> v != null ? v.doubleValue() : null));
    }

    public IntegerValue compareTo(Value<? extends Number> otherValue) {

        ValueFunction<? extends Number, Integer> func = new ValueFunction<>("compareTo", getWrappedValue(), v -> {
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
        });
        func.addDependentValue(otherValue);

        return new IntegerValue(func);
    }

    public BooleanValue greaterThan(Number otherValue) {
        return greaterThan(new ConstantValue<>(otherValue));
    }

    public BooleanValue greaterThan(Value<? extends Number> otherValue) {
        ValueFunction<Integer, Boolean> func = new ValueFunction<>("greaterThan",
                compareTo(otherValue).getWrappedValue(), v -> v > 0);
        func.addDependentValue(otherValue);
        return new BooleanValue(func);
    }

    public BooleanValue greaterThanOrEquals(Number otherValue) {
        return greaterThanOrEquals(new ConstantValue<>(otherValue));
    }

    public BooleanValue greaterThanOrEquals(Value<? extends Number> otherValue) {
        ValueFunction<Integer, Boolean> func = new ValueFunction<>("greaterThanOrEquals",
                compareTo(otherValue).getWrappedValue(), v -> v >= 0);
        func.addDependentValue(otherValue);
        return new BooleanValue(func);
    }

    public BooleanValue lessThan(Number otherValue) {
        return lessThan(new ConstantValue<>(otherValue));
    }

    public BooleanValue lessThan(Value<? extends Number> otherValue) {
        ValueFunction<Integer, Boolean> func = new ValueFunction<>("lessThan",
                compareTo(otherValue).getWrappedValue(), v -> v < 0);
        func.addDependentValue(otherValue);
        return new BooleanValue(func);
    }

    public BooleanValue lessThanOrEquals(Number otherValue) {
        return lessThanOrEquals(new ConstantValue<>(otherValue));
    }

    public BooleanValue lessThanOrEquals(Value<? extends Number> otherValue) {
        ValueFunction<Integer, Boolean> func = new ValueFunction<>("lessThanOrEquals",
                compareTo(otherValue).getWrappedValue(), v -> v <= 0);
        func.addDependentValue(otherValue);
        return new BooleanValue(func);
    }

    @Override
    public NumberValue<T> updateOn(Executor nullValue) {
        return new NumberValue<>(super.updateOn(nullValue).getWrappedValue());
    }

    @Override
    public NumberValue<T> updateOn(Value<? extends Executor> value) {
        return new NumberValue<>(super.updateOn(value).getWrappedValue());
    }

    @Override
    public NumberValue<T> withNullValueAs(T nullValue) {
        return new NumberValue<>(super.withNullValueAs(nullValue).getWrappedValue());
    }

    @Override
    public NumberValue<T> withNullValueAs(Value<T> value) {
        return new NumberValue<>(super.withNullValueAs(value).getWrappedValue());
    }

    @Override
    public NumberValue<T> debounce(Value<TimeUnit> timeUnit, Value<Long> time) {
        return new NumberValue<>(super.debounce(timeUnit, time).getWrappedValue());
    }

    @Override
    public NumberValue<T> debounce(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new NumberValue<>(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public NumberValue<T> debounce(TimeUnit timeUnit, long time) {
        return new NumberValue<>(super.debounce(timeUnit, time).getWrappedValue());
    }

    @Override
    public NumberValue<T> debounce(Executor executor, TimeUnit timeUnit, long time) {
        return new NumberValue<>(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public NumberValue<T> delay(Value<TimeUnit> timeUnit, Value<Long> time) {
        return new NumberValue<>(super.delay(timeUnit, time).getWrappedValue());
    }

    @Override
    public NumberValue<T> delay(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new NumberValue<>(super.delay(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public NumberValue<T> delay(TimeUnit timeUnit, long time) {
        return new NumberValue<>(super.delay(timeUnit, time).getWrappedValue());
    }

    @Override
    public NumberValue<T> delay(Executor executor, TimeUnit timeUnit, long time) {
        return new NumberValue<>(super.delay(executor, timeUnit, time).getWrappedValue());
    }
}
