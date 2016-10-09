package ru.threedisevenzeror.datatree.wrapper.text;

import ru.threedisevenzeror.datatree.base.ConstantValue;
import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.functional.ValueFunction;
import ru.threedisevenzeror.datatree.wrapper.ObjectValue;
import ru.threedisevenzeror.datatree.wrapper.number.IntegerValue;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class TextValue<T extends CharSequence> extends ObjectValue<T> {

    public TextValue() {

    }

    public TextValue(T value) {
        this(new ConstantValue<>(value));
    }

    public TextValue(Value<T> value) {
        super(value);
    }

    public IntegerValue length() {
        return new IntegerValue(new ValueFunction<>("length", getWrappedValue(), v -> v != null ? v.length() : 0));
    }

    @Override
    public TextValue<T> withNullValueAs(T nullValue) {
        return new TextValue<>(super.withNullValueAs(nullValue).getWrappedValue());
    }

    @Override
    public TextValue<T> withNullValueAs(Value<T> value) {
        return new TextValue<>(super.withNullValueAs(value).getWrappedValue());
    }

    @Override
    public TextValue<T> debounce(Value<TimeUnit> timeUnit, Value<Long> time) {
        return new TextValue<>(super.debounce(timeUnit, time).getWrappedValue());
    }

    @Override
    public TextValue<T> debounce(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new TextValue<>(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public TextValue<T> debounce(TimeUnit timeUnit, long time) {
        return new TextValue<>(super.debounce(timeUnit, time).getWrappedValue());
    }

    @Override
    public TextValue<T> debounce(Executor executor, TimeUnit timeUnit, long time) {
        return new TextValue<>(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public TextValue<T> delay(Value<TimeUnit> timeUnit, Value<Long> time) {
        return new TextValue<>(super.delay(timeUnit, time).getWrappedValue());
    }

    @Override
    public TextValue<T> delay(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new TextValue<>(super.delay(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public TextValue<T> delay(TimeUnit timeUnit, long time) {
        return new TextValue<>(super.delay(timeUnit, time).getWrappedValue());
    }

    @Override
    public TextValue<T> delay(Executor executor, TimeUnit timeUnit, long time) {
        return new TextValue<>(super.delay(executor, timeUnit, time).getWrappedValue());
    }
}
