package ru.threedisevenzeror.datatree.wrapper.number;

import ru.threedisevenzeror.datatree.base.Value;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class ByteValue extends NumberValue<Byte> {

    public ByteValue() {

    }

    public ByteValue(Byte value) {
        super(value);
    }

    public ByteValue(Value<Byte> value) {
        super(value);
    }

    @Override
    public ByteValue asByte() {
        return this;
    }

    @Override
    public ByteValue withNullValueAs(Byte nullValue) {
        return new ByteValue(super.withNullValueAs(nullValue).getWrappedValue());
    }

    @Override
    public ByteValue withNullValueAs(Value<Byte> value) {
        return new ByteValue(super.withNullValueAs(value).getWrappedValue());
    }

    @Override
    public ByteValue debounce(Value<TimeUnit> timeUnit, Value<Long> time) {
        return new ByteValue(super.debounce(timeUnit, time).getWrappedValue());
    }

    @Override
    public ByteValue debounce(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new ByteValue(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public ByteValue debounce(TimeUnit timeUnit, long time) {
        return new ByteValue(super.debounce(timeUnit, time).getWrappedValue());
    }

    @Override
    public ByteValue debounce(Executor executor, TimeUnit timeUnit, long time) {
        return new ByteValue(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public ByteValue delay(Value<TimeUnit> timeUnit, Value<Long> time) {
        return new ByteValue(super.delay(timeUnit, time).getWrappedValue());
    }

    @Override
    public ByteValue delay(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new ByteValue(super.delay(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public ByteValue delay(TimeUnit timeUnit, long time) {
        return new ByteValue(super.delay(timeUnit, time).getWrappedValue());
    }

    @Override
    public ByteValue delay(Executor executor, TimeUnit timeUnit, long time) {
        return new ByteValue(super.delay(executor, timeUnit, time).getWrappedValue());
    }
}
