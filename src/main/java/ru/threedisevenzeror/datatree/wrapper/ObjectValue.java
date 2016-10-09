package ru.threedisevenzeror.datatree.wrapper;

import ru.threedisevenzeror.datatree.base.AbstractValueWrapper;
import ru.threedisevenzeror.datatree.base.ConstantValue;
import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.functional.ValueFunction;
import ru.threedisevenzeror.datatree.logical.DebounceValue;
import ru.threedisevenzeror.datatree.logical.DelayValue;
import ru.threedisevenzeror.datatree.wrapper.bool.BooleanValue;
import ru.threedisevenzeror.datatree.wrapper.text.StringValue;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class ObjectValue<T> extends AbstractValueWrapper<T> {

    public ObjectValue() {

    }

    public ObjectValue(T value) {
        super(new ConstantValue<>(value));
    }

    public ObjectValue(Value<T> value) {
        super(value);
    }

    public StringValue asString() {
        return new StringValue(new ValueFunction<>("asString", getWrappedValue(),
                v -> v != null ? v.toString() : null));
    }

    public BooleanValue notEquals(Value<?> obj) {
        return equals(obj).not();
    }

    public BooleanValue equals(Value<?> obj) {
        ValueFunction<?, Boolean> function = new ValueFunction<>("equals", getWrappedValue(), f -> Objects.equals(f, obj.get()));
        function.addDependentValue(obj);
        return new BooleanValue(function);
    }

    public ObjectValue<T> debounce(Value<TimeUnit> timeUnit, Value<Long> time) {
        return new ObjectValue<>(new DebounceValue<>(getWrappedValue(),
                new ConstantValue<>(Executors.newCachedThreadPool()), timeUnit, time));
    }

    public ObjectValue<T> debounce(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new ObjectValue<>(new DebounceValue<>(getWrappedValue(), executor, timeUnit, time));
    }

    public ObjectValue<T> debounce(TimeUnit timeUnit, long time) {
        return debounce(new ConstantValue<>(Executors.newSingleThreadExecutor()),
                new ConstantValue<>(timeUnit), new ConstantValue<>(time));
    }

    public ObjectValue<T> debounce(Executor executor, TimeUnit timeUnit, long time) {
        return debounce(new ConstantValue<>(executor), new ConstantValue<>(timeUnit), new ConstantValue<>(time));
    }

    public ObjectValue<T> delay(Value<TimeUnit> timeUnit, Value<Long> time) {
        return delay(new ConstantValue<>(Executors.newSingleThreadExecutor()), timeUnit, time);
    }

    public ObjectValue<T> delay(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new ObjectValue<>(new DelayValue<>(getWrappedValue(), executor, timeUnit, time));
    }

    public ObjectValue<T> delay(TimeUnit timeUnit, long time) {
        return delay(Executors.newSingleThreadExecutor(), timeUnit, time);
    }

    public ObjectValue<T> delay(Executor executor, TimeUnit timeUnit, long time) {
        return delay(new ConstantValue<>(executor), new ConstantValue<>(timeUnit), new ConstantValue<>(time));
    }
}
