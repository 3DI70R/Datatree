package ru.threedisevenzeror.datatree.wrapper;

import ru.threedisevenzeror.datatree.base.AbstractValueWrapper;
import ru.threedisevenzeror.datatree.base.ConstantValue;
import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.functional.ValueFunction;
import ru.threedisevenzeror.datatree.base.functional.ValueSupplier;
import ru.threedisevenzeror.datatree.logical.DebounceValue;
import ru.threedisevenzeror.datatree.logical.DelayValue;
import ru.threedisevenzeror.datatree.logical.UpdateOnAnotherThreadValue;
import ru.threedisevenzeror.datatree.util.Function;
import ru.threedisevenzeror.datatree.wrapper.bool.BooleanValue;
import ru.threedisevenzeror.datatree.wrapper.text.StringValue;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class ObjectValue<T> extends AbstractValueWrapper<T> {

    public ObjectValue() {

    }

    public ObjectValue(T value) {
        super(Value.constant(value));
    }

    public ObjectValue(Value<T> value) {
        super(value);
    }

    @Override
    public StringValue asString() {
        return getWrappedValue().asString();
    }

    @Override
    public BooleanValue notEquals(Value<?> obj) {
        return getWrappedValue().notEquals(obj);
    }

    @Override
    public BooleanValue equals(Value<?> obj) {
        return getWrappedValue().equals(obj);
    }

    @Override
    public <R> ObjectValue<R> withFunction(Function<T, R> function) {
        return new ObjectValue<>(getWrappedValue().withFunction(function));
    }

    @Override
    public <R> ObjectValue<R> withFunction(Value<Function<T, R>> function) {
        return new ObjectValue<>(getWrappedValue().withFunction(function));
    }

    @Override
    public ObjectValue<T> updateOn(Executor executor) {
        return new ObjectValue<>(getWrappedValue().updateOn(executor));
    }

    @Override
    public ObjectValue<T> updateOn(Value<? extends Executor> executor) {
        return new ObjectValue<>(getWrappedValue().updateOn(executor));
    }

    @Override
    public ObjectValue<T> withNullValueAs(T nullValue) {
        return new ObjectValue<>(getWrappedValue().withNullValueAs(nullValue));
    }

    @Override
    public ObjectValue<T> withNullValueAs(Value<T> value) {
        return new ObjectValue<>(getWrappedValue().withNullValueAs(value));
    }

    public ObjectValue<T> debounce(Value<TimeUnit> timeUnit, Value<Long> time) {
        return new ObjectValue<>(getWrappedValue().debounce(timeUnit, time));
    }

    public ObjectValue<T> debounce(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new ObjectValue<>(getWrappedValue().debounce(executor, timeUnit, time));
    }

    public ObjectValue<T> debounce(TimeUnit timeUnit, long time) {
        return new ObjectValue<>(getWrappedValue().debounce(timeUnit, time));
    }

    public ObjectValue<T> debounce(Executor executor, TimeUnit timeUnit, long time) {
        return new ObjectValue<>(getWrappedValue().debounce(executor, timeUnit, time));
    }

    public ObjectValue<T> delay(Value<TimeUnit> timeUnit, Value<Long> time) {
        return new ObjectValue<>(getWrappedValue().delay(timeUnit, time));
    }

    public ObjectValue<T> delay(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new ObjectValue<>(getWrappedValue().delay(timeUnit, time));
    }

    public ObjectValue<T> delay(TimeUnit timeUnit, long time) {
        return new ObjectValue<>(getWrappedValue().delay(timeUnit, time));
    }

    public ObjectValue<T> delay(Executor executor, TimeUnit timeUnit, long time) {
        return new ObjectValue<>(getWrappedValue().delay(executor, timeUnit, time));
    }
}
