package ru.threedisevenzeror.datatree.typed.text;

import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.ValueFunction;
import ru.threedisevenzeror.datatree.typed.ObjectValue;
import ru.threedisevenzeror.datatree.typed.number.IntegerValue;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class TextValue<T extends CharSequence> extends ObjectValue<T> {

    public TextValue(Value<T> value) {
        super(value);
    }

    public IntegerValue length() {
        return new IntegerValue(new ValueFunction<>(getWrappedValue(), v -> v != null ? v.length() : 0));
    }

    @Override
    public TextValue<T> debounce(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new TextValue<>(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public TextValue<T> debounce(Executor executor, TimeUnit timeUnit, long time) {
        return new TextValue<>(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public TextValue<T> delay(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new TextValue<>(super.delay(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public TextValue<T> delay(Executor executor, TimeUnit timeUnit, long time) {
        return new TextValue<>(super.delay(executor, timeUnit, time).getWrappedValue());
    }
}
