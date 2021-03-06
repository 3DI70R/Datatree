package ru.threedisevenzeror.datatree.wrapper.number;

import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.wrapper.text.StringValue;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class ShortValue extends NumberValue<Short> {

    public ShortValue() {

    }

    public ShortValue(Short value) {
        super(value);
    }

    public ShortValue(Value<Short> value) {
        super(value);
    }

    @Override
    public ShortValue asShort() {
        return this;
    }

    @Override
    public ShortValue updateOn(Executor nullValue) {
        return new ShortValue(super.updateOn(nullValue).getWrappedValue());
    }

    @Override
    public ShortValue updateOn(Value<? extends Executor> value) {
        return new ShortValue(super.updateOn(value).getWrappedValue());
    }

    @Override
    public ShortValue withNullValueAs(Short nullValue) {
        return new ShortValue(super.withNullValueAs(nullValue).getWrappedValue());
    }

    @Override
    public ShortValue withNullValueAs(Value<Short> value) {
        return new ShortValue(super.withNullValueAs(value).getWrappedValue());
    }

    @Override
    public ShortValue debounce(Value<TimeUnit> timeUnit, Value<Long> time) {
        return new ShortValue(super.debounce(timeUnit, time).getWrappedValue());
    }

    @Override
    public ShortValue debounce(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new ShortValue(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public ShortValue debounce(TimeUnit timeUnit, long time) {
        return new ShortValue(super.debounce(timeUnit, time).getWrappedValue());
    }

    @Override
    public ShortValue debounce(Executor executor, TimeUnit timeUnit, long time) {
        return new ShortValue(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public ShortValue delay(Value<TimeUnit> timeUnit, Value<Long> time) {
        return new ShortValue(super.delay(timeUnit, time).getWrappedValue());
    }

    @Override
    public ShortValue delay(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new ShortValue(super.delay(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public ShortValue delay(TimeUnit timeUnit, long time) {
        return new ShortValue(super.delay(timeUnit, time).getWrappedValue());
    }

    @Override
    public ShortValue delay(Executor executor, TimeUnit timeUnit, long time) {
        return new ShortValue(super.delay(executor, timeUnit, time).getWrappedValue());
    }
}
