package ru.threedisevenzeror.datatree.wrapper.number;

import ru.threedisevenzeror.datatree.base.Value;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class IntegerValue extends NumberValue<Integer> {

    public IntegerValue() {

    }

    public IntegerValue(Integer value) {
        super(value);
    }

    public IntegerValue(Value<Integer> value) {
        super(value);
    }

    @Override
    public IntegerValue asInteger() {
        return this;
    }

    @Override
    public IntegerValue debounce(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new IntegerValue(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public IntegerValue debounce(Executor executor, TimeUnit timeUnit, long time) {
        return new IntegerValue(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public IntegerValue delay(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new IntegerValue(super.delay(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public IntegerValue delay(Executor executor, TimeUnit timeUnit, long time) {
        return new IntegerValue(super.delay(executor, timeUnit, time).getWrappedValue());
    }
}
