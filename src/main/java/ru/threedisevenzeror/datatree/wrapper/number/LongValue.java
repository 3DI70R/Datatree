package ru.threedisevenzeror.datatree.wrapper.number;

import ru.threedisevenzeror.datatree.base.Value;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class LongValue extends NumberValue<Long> {

    public LongValue() {

    }

    public LongValue(Long value) {
        super(value);
    }

    public LongValue(Value<Long> value) {
        super(value);
    }

    @Override
    public LongValue asLong() {
        return this;
    }

    @Override
    public LongValue updateOn(Executor nullValue) {
        return new LongValue(super.updateOn(nullValue).getWrappedValue());
    }

    @Override
    public LongValue updateOn(Value<? extends Executor> value) {
        return new LongValue(super.updateOn(value).getWrappedValue());
    }

    @Override
    public LongValue withNullValueAs(Long nullValue) {
        return new LongValue(super.withNullValueAs(nullValue).getWrappedValue());
    }

    @Override
    public LongValue withNullValueAs(Value<Long> value) {
        return new LongValue(super.withNullValueAs(value).getWrappedValue());
    }

    @Override
    public LongValue debounce(Value<TimeUnit> timeUnit, Value<Long> time) {
        return new LongValue(super.debounce(timeUnit, time).getWrappedValue());
    }

    @Override
    public LongValue debounce(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new LongValue(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public LongValue debounce(TimeUnit timeUnit, long time) {
        return new LongValue(super.debounce(timeUnit, time).getWrappedValue());
    }

    @Override
    public LongValue debounce(Executor executor, TimeUnit timeUnit, long time) {
        return new LongValue(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public LongValue delay(Value<TimeUnit> timeUnit, Value<Long> time) {
        return new LongValue(super.delay(timeUnit, time).getWrappedValue());
    }

    @Override
    public LongValue delay(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new LongValue(super.delay(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public LongValue delay(TimeUnit timeUnit, long time) {
        return new LongValue(super.delay(timeUnit, time).getWrappedValue());
    }

    @Override
    public LongValue delay(Executor executor, TimeUnit timeUnit, long time) {
        return new LongValue(super.delay(executor, timeUnit, time).getWrappedValue());
    }
}
