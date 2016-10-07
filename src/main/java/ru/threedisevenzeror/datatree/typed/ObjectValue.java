package ru.threedisevenzeror.datatree.typed;

import ru.threedisevenzeror.datatree.base.AbstractValueWrapper;
import ru.threedisevenzeror.datatree.base.ConstantValue;
import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.ValueFunction;
import ru.threedisevenzeror.datatree.logical.DebounceValue;
import ru.threedisevenzeror.datatree.logical.DelayValue;
import ru.threedisevenzeror.datatree.typed.text.StringValue;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class ObjectValue<T> extends AbstractValueWrapper<T> {

    public ObjectValue(T value) {
        super(new ConstantValue<>(value));
    }

    public ObjectValue(Value<T> value) {
        super(value);
    }

    public StringValue asString() {
        return new StringValue(new ValueFunction<>(getWrappedValue(), v -> v != null ? v.toString() : null));
    }

    public BooleanValue notEquals(Value<?> obj) {
        return new BooleanValue(new ValueFunction<>(obj, f -> !Objects.equals(f, get())));
    }

    public BooleanValue equals(Value<?> obj) {
        return new BooleanValue(new ValueFunction<>(obj, f -> Objects.equals(f, get())));
    }

    public ObjectValue<T> debounce(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new ObjectValue<>(new DebounceValue<>(getWrappedValue(), executor, timeUnit, time));
    }

    public ObjectValue<T> debounce(Executor executor, TimeUnit timeUnit, long time) {
        return debounce(new ConstantValue<>(executor), new ConstantValue<>(timeUnit), new ConstantValue<>(time));
    }

    public ObjectValue<T> delay(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new ObjectValue<>(new DelayValue<>(getWrappedValue(), executor, timeUnit, time));
    }

    public ObjectValue<T> delay(Executor executor, TimeUnit timeUnit, long time) {
        return delay(new ConstantValue<>(executor), new ConstantValue<>(timeUnit), new ConstantValue<>(time));
    }
}
