package ru.threedisevenzeror.datatree.wrapper.bool;

import ru.threedisevenzeror.datatree.base.ConstantValue;
import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.functional.ValueFunction;
import ru.threedisevenzeror.datatree.wrapper.ObjectValue;
import ru.threedisevenzeror.datatree.wrapper.number.IntegerValue;
import ru.threedisevenzeror.datatree.wrapper.number.NumberValue;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class BooleanValue extends ObjectValue<Boolean> {

    public BooleanValue() {

    }

    public BooleanValue(Boolean value) {
        this(new ConstantValue<>(value));
    }

    public BooleanValue(Value<Boolean> value) {
        super(value);
    }

    public BooleanValue and(Value<Boolean> value) {
        return new AndBooleanValue(getWrappedValue(), value);
    }

    public BooleanValue or(Value<Boolean> value) {
        return new OrBooleanValue(getWrappedValue(), value);
    }

    public BooleanValue not() {
        return new BooleanValue(new ValueFunction<>("not", getWrappedValue(), b -> b != null ? !b : null));
    }

    public IntegerValue asNumber() {
        return new IntegerValue(new ValueFunction<>("asNumber", getWrappedValue(), b -> b != null ? (b ? 1 : 0) : null));
    }

    public <T> ObjectValue<T> asCondition(T trueValue,
                                          T falseValue) {
        return asCondition(trueValue, falseValue, null);
    }

    public <T> ObjectValue<T> asCondition(T trueValue,
                                          T falseValue,
                                          T nullValue) {
        return new ObjectValue<>(new ValueFunction<>("asCondition", getWrappedValue(), b -> {
            if(b != null) {
                return b ? trueValue : falseValue;
            } else {
                return nullValue;
            }
        }));
    }

    public <T> ObjectValue<T> asCondition(Value<? extends T> trueValue,
                                          Value<? extends T> falseValue) {
        return asCondition(trueValue, falseValue, new ConstantValue<>(null));
    }

    public <T> ObjectValue<T> asCondition(Value<? extends T> trueValue,
                                    Value<? extends T> falseValue,
                                    Value<? extends T> nullValue) {
        ValueFunction<Boolean, T> value = new ValueFunction<>("asCondition", getWrappedValue(), b -> {
            if(b != null) {
                return b ? trueValue.get() : falseValue.get();
            } else {
                return nullValue.get();
            }
        });
        value.addDependentValue(trueValue);
        value.addDependentValue(falseValue);
        value.addDependentValue(nullValue);

        return new ObjectValue<>(value);
    }

    @Override
    public BooleanValue withNullValueAs(Boolean nullValue) {
        return new BooleanValue(super.withNullValueAs(nullValue).getWrappedValue());
    }

    @Override
    public BooleanValue withNullValueAs(Value<Boolean> value) {
        return new BooleanValue(super.withNullValueAs(value).getWrappedValue());
    }

    @Override
    public BooleanValue debounce(Value<TimeUnit> timeUnit, Value<Long> time) {
        return new BooleanValue(super.debounce(timeUnit, time).getWrappedValue());
    }

    @Override
    public BooleanValue debounce(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new BooleanValue(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public BooleanValue debounce(TimeUnit timeUnit, long time) {
        return new BooleanValue(super.debounce(timeUnit, time).getWrappedValue());
    }

    @Override
    public BooleanValue debounce(Executor executor, TimeUnit timeUnit, long time) {
        return new BooleanValue(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public BooleanValue delay(Value<TimeUnit> timeUnit, Value<Long> time) {
        return new BooleanValue(super.delay(timeUnit, time).getWrappedValue());
    }

    @Override
    public BooleanValue delay(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new BooleanValue(super.delay(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public BooleanValue delay(TimeUnit timeUnit, long time) {
        return new BooleanValue(super.delay(timeUnit, time).getWrappedValue());
    }

    @Override
    public BooleanValue delay(Executor executor, TimeUnit timeUnit, long time) {
        return new BooleanValue(super.delay(executor, timeUnit, time).getWrappedValue());
    }
}
