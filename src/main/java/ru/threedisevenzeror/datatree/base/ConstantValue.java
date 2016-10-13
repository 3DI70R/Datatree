package ru.threedisevenzeror.datatree.base;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class ConstantValue<T> extends AbstractValue<T> {

    private T value;

    public ConstantValue(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void addOnValueChangedListener(OnValueChangedListener<T> listener) {
        // noop
    }

    public void removeOnValueChangedListener(OnValueChangedListener<T> listener) {
        // noop
    }

    @Override
    public Value<T> updateOn(Executor executor) {
        return this;
    }

    @Override
    public Value<T> updateOn(Value<? extends Executor> executor) {
        return this;
    }

    @Override
    public Value<T> debounce(Value<TimeUnit> timeUnit, Value<Long> time) {
        return this;
    }

    @Override
    public Value<T> debounce(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return this;
    }

    @Override
    public Value<T> debounce(TimeUnit timeUnit, long time) {
        return this;
    }

    @Override
    public Value<T> debounce(Executor executor, TimeUnit timeUnit, long time) {
        return this;
    }

    @Override
    public Value<T> delay(Value<TimeUnit> timeUnit, Value<Long> time) {
        return this;
    }

    @Override
    public Value<T> delay(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return this;
    }

    @Override
    public Value<T> delay(TimeUnit timeUnit, long time) {
        return this;
    }

    @Override
    public Value<T> delay(Executor executor, TimeUnit timeUnit, long time) {
        return this;
    }
}
