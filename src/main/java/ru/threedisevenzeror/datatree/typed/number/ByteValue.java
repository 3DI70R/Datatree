package ru.threedisevenzeror.datatree.typed.number;

import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.typed.ObjectValue;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class ByteValue extends NumberValue<Byte> {

    public ByteValue(Value<Byte> value) {
        super(value);
    }

    @Override
    public ByteValue asByte() {
        return this;
    }


    @Override
    public ByteValue debounce(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new ByteValue(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public ByteValue debounce(Executor executor, TimeUnit timeUnit, long time) {
        return new ByteValue(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public ByteValue delay(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new ByteValue(super.delay(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public ByteValue delay(Executor executor, TimeUnit timeUnit, long time) {
        return new ByteValue(super.delay(executor, timeUnit, time).getWrappedValue());
    }
}
