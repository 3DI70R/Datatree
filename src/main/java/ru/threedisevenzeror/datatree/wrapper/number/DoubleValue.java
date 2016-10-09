package ru.threedisevenzeror.datatree.wrapper.number;

import ru.threedisevenzeror.datatree.base.Value;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class DoubleValue extends NumberValue<Double> {

    public DoubleValue() {

    }

    public DoubleValue(Double value) {
        super(value);
    }

    public DoubleValue(Value<Double> value) {
        super(value);
    }

    @Override
    public DoubleValue asDouble() {
        return this;
    }

    @Override
    public DoubleValue withNullValueAs(Double nullValue) {
        return new DoubleValue(super.withNullValueAs(nullValue).getWrappedValue());
    }

    @Override
    public DoubleValue withNullValueAs(Value<Double> value) {
        return new DoubleValue(super.withNullValueAs(value).getWrappedValue());
    }

    @Override
    public DoubleValue debounce(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new DoubleValue(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public DoubleValue debounce(Value<TimeUnit> timeUnit, Value<Long> time) {
        return new DoubleValue(super.debounce(timeUnit, time).getWrappedValue());
    }

    @Override
    public DoubleValue debounce(Executor executor, TimeUnit timeUnit, long time) {
        return new DoubleValue(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public DoubleValue debounce(TimeUnit timeUnit, long time) {
        return new DoubleValue(super.debounce(timeUnit, time).getWrappedValue());
    }

    @Override
    public DoubleValue delay(Value<TimeUnit> timeUnit, Value<Long> time) {
        return new DoubleValue(super.delay(timeUnit, time).getWrappedValue());
    }

    @Override
    public DoubleValue delay(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new DoubleValue(super.delay(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public DoubleValue delay(TimeUnit timeUnit, long time) {
        return new DoubleValue(super.delay(timeUnit, time).getWrappedValue());
    }

    @Override
    public DoubleValue delay(Executor executor, TimeUnit timeUnit, long time) {
        return new DoubleValue(super.delay(executor, timeUnit, time).getWrappedValue());
    }
}
