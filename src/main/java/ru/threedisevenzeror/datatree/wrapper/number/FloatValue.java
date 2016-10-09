package ru.threedisevenzeror.datatree.wrapper.number;

import ru.threedisevenzeror.datatree.base.Value;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class FloatValue extends NumberValue<Float> {

    public FloatValue() {

    }

    public FloatValue(Float value) {
        super(value);
    }

    public FloatValue(Value<Float> value) {
        super(value);
    }

    @Override
    public FloatValue asFloat() {
        return this;
    }

    @Override
    public FloatValue debounce(Value<TimeUnit> timeUnit, Value<Long> time) {
        return new FloatValue(super.debounce(timeUnit, time).getWrappedValue());
    }

    @Override
    public FloatValue debounce(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new FloatValue(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public FloatValue debounce(TimeUnit timeUnit, long time) {
        return new FloatValue(super.debounce(timeUnit, time).getWrappedValue());
    }

    @Override
    public FloatValue debounce(Executor executor, TimeUnit timeUnit, long time) {
        return new FloatValue(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public FloatValue delay(Value<TimeUnit> timeUnit, Value<Long> time) {
        return new FloatValue(super.delay(timeUnit, time).getWrappedValue());
    }

    @Override
    public FloatValue delay(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new FloatValue(super.delay(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public FloatValue delay(TimeUnit timeUnit, long time) {
        return new FloatValue(super.delay(timeUnit, time).getWrappedValue());
    }

    @Override
    public FloatValue delay(Executor executor, TimeUnit timeUnit, long time) {
        return new FloatValue(super.delay(executor, timeUnit, time).getWrappedValue());
    }
}
