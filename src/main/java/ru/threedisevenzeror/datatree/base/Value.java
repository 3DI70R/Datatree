package ru.threedisevenzeror.datatree.base;

import ru.threedisevenzeror.datatree.base.functional.ValueFunction;
import ru.threedisevenzeror.datatree.base.functional.ValueSupplier;
import ru.threedisevenzeror.datatree.logical.DebounceValue;
import ru.threedisevenzeror.datatree.logical.DelayValue;
import ru.threedisevenzeror.datatree.logical.UpdateOnAnotherThreadValue;
import ru.threedisevenzeror.datatree.util.*;
import ru.threedisevenzeror.datatree.wrapper.ObjectValue;
import ru.threedisevenzeror.datatree.wrapper.bool.BooleanValue;
import ru.threedisevenzeror.datatree.wrapper.collection.ArrayValue;
import ru.threedisevenzeror.datatree.wrapper.collection.ListValue;
import ru.threedisevenzeror.datatree.wrapper.collection.MapValue;
import ru.threedisevenzeror.datatree.wrapper.number.*;
import ru.threedisevenzeror.datatree.wrapper.text.StringValue;
import ru.threedisevenzeror.datatree.wrapper.text.TextValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 *
 * Абстрактное значение
 * Самая главная сущность данной концепции
 *
 * Содержит в себе какое либо значение, которое может изменяться
 * Изменение значения можно отслеживать при помощи add/remove onValueChangeListener
 */
public interface Value<T> {

    /**
     * Получить значение, которое содержит эта инстанция Value
     * @return значение содержащееся в этом value
     */
    T get();

    /**
     * Добавить listener, который будет вызываться каждый раз, при изменении этого значения
     * @param listener listener который нужно уведомлять о изменениях
     */
    void addOnValueChangedListener(OnValueChangedListener<T> listener);

    /**
     * Удалить listener из списка, чтобы перестать получать уведомления о изменении этого значения
     * @param listener listener который нужно удалить
     */
    void removeOnValueChangedListener(OnValueChangedListener<T> listener);

    // DEFAULT METHODS

    default StringValue asString() {
        return new StringValue(new ValueFunction<>("asString", this, v -> v != null ? v.toString() : null));
    }

    default BooleanValue notEquals(Value<?> obj) {
        return equals(obj).not();
    }

    default BooleanValue equals(Value<?> obj) {
        ValueFunction<?, Boolean> function = new ValueFunction<>("equals", this, f -> Objects.equals(f, obj.get()));
        function.addDependentValue(obj);
        return new BooleanValue(function);
    }

    default <R> Value<R> withFunction(Function<T, R> function) {
        return withFunction(constant(function));
    }

    default  <R> Value<R> withFunction(Value<Function<T, R>> function) {
        ValueFunction<T, R> func = new ValueFunction<>("custom function", this, v -> {
            Function<T, R> otherFunc = function.get();
            if(otherFunc != null) {
                return otherFunc.apply(v);
            } else {
                return null;
            }
        });
        func.addDependentValue(function);
        return func;
    }

    default Value<T> updateOn(Executor executor) {
        return updateOn(constant(executor));
    }

    default Value<T> updateOn(Value<? extends Executor> executor) {
        return new UpdateOnAnotherThreadValue<>(this, executor);
    }

    default Value<T> withNullValueAs(T nullValue) {
        return withNullValueAs(constant(nullValue));
    }

    default Value<T> withNullValueAs(Value<T> value) {
        ValueFunction<T, T> func = new ValueFunction<>("withNullValueAs", this, t -> t != null ? t : value.get());
        func.addDependentValue(value);
        return func;
    }

    default Value<T> debounce(Value<TimeUnit> timeUnit, Value<Long> time) {
        return debounce( constant(Executors.newCachedThreadPool()), timeUnit, time);
    }

    default Value<T> debounce(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new DebounceValue<>(this, executor, timeUnit, time);
    }

    default Value<T> debounce(TimeUnit timeUnit, long time) {
        return debounce(constant(Executors.newSingleThreadExecutor()), constant(timeUnit), constant(time));
    }

    default Value<T> debounce(Executor executor, TimeUnit timeUnit, long time) {
        return debounce(constant(executor), constant(timeUnit), constant(time));
    }

    default Value<T> delay(Value<TimeUnit> timeUnit, Value<Long> time) {
        return delay(constant(Executors.newSingleThreadExecutor()), timeUnit, time);
    }

    default Value<T> delay(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new DelayValue<>(this, executor, timeUnit, time);
    }

    default Value<T> delay(TimeUnit timeUnit, long time) {
        return delay(Executors.newSingleThreadExecutor(), timeUnit, time);
    }

    default Value<T> delay(Executor executor, TimeUnit timeUnit, long time) {
        return delay(constant(executor), constant(timeUnit), constant(time));
    }

    // UTILITY METHODS

    static <T> Value<T> empty() {
        return new ConstantValue<>(null);
    }

    static BooleanValue constant(Boolean value) {
        return new BooleanValue(new ConstantValue<>(value));
    }

    static ByteValue constant(Byte value) {
        return new ByteValue(new ConstantValue<>(value));
    }

    static DoubleValue constant(Double value) {
        return new DoubleValue(new ConstantValue<>(value));
    }

    static FloatValue constant(Float value) {
        return new FloatValue(new ConstantValue<>(value));
    }

    static IntegerValue constant(Integer value) {
        return new IntegerValue(new ConstantValue<>(value));
    }

    static LongValue constant(Long value) {
        return new LongValue(new ConstantValue<>(value));
    }

    static ShortValue constant(Short value) {
        return new ShortValue(new ConstantValue<>(value));
    }

    static <T extends CharSequence> TextValue<T> constant(T value) {
        return new TextValue<>(new ConstantValue<>(value));
    }

    static StringValue constant(String value) {
        return new StringValue(new ConstantValue<>(value));
    }

    static <T> ArrayValue<T> constant(T... value) {
        return new ArrayValue<>(new ConstantValue<>(value));
    }

    static <T> ListValue<T> constant(List<T> items) {
        return new ListValue<>(new ConstantValue<>(items));
    }

    static <K, V> MapValue<K, V> constant(Map<K, V> items) {
        return new MapValue<>(new ConstantValue<>(items));
    }

    static <T> ObjectValue<T> constant(T value) {
        return new ObjectValue<>(new ConstantValue<>(value));
    }

    static <T1, T2, R> Value<R> zip(Value<T1> v1, Value<T2> v2, Function2<T1, T2, R> function) {
        return new ValueSupplier<>("zip2", () ->
                function.apply(v1.get(), v2.get()),
                v1, v2);
    }

    static <T1, T2, T3, R> Value<R> zip(Value<T1> v1, Value<T2> v2, Value<T3> v3, Function3<T1, T2, T3, R> function) {
        return new ValueSupplier<>("zip3", () ->
                function.apply(v1.get(), v2.get(), v3.get()),
                v1, v2, v3);
    }

    static <T1, T2, T3, T4, R> Value<R> zip(Value<T1> v1, Value<T2> v2, Value<T3> v3, Value<T4> v4, Function4<T1, T2, T3, T4, R> function) {
        return new ValueSupplier<>("zip4", () ->
                function.apply(v1.get(), v2.get(), v3.get(), v4.get()),
                v1, v2, v3, v4);
    }

    static <T1, T2, T3, T4, T5, R> Value<R> zip(Value<T1> v1, Value<T2> v2, Value<T3> v3, Value<T4> v4,
                                                          Value<T5> v5, Function5<T1, T2, T3, T4, T5, R> function) {
        return new ValueSupplier<>("zip5", () ->
                function.apply(v1.get(), v2.get(), v3.get(), v4.get(), v5.get()),
                v1, v2, v3, v4, v5);
    }

    static <T1, T2, T3, T4, T5, T6, R> Value<R> zip(Value<T1> v1, Value<T2> v2, Value<T3> v3, Value<T4> v4,
                                                              Value<T5> v5, Value<T6> v6, Function6<T1, T2, T3, T4, T5, T6, R> function) {
        return new ValueSupplier<>("zip6", () ->
                function.apply(v1.get(), v2.get(), v3.get(), v4.get(), v5.get(), v6.get()),
                v1, v2, v3, v4, v5, v6);
    }

    static <T1, T2, T3, T4, T5, T6, T7, R> Value<R> zip(Value<T1> v1, Value<T2> v2, Value<T3> v3, Value<T4> v4,
                                                                  Value<T5> v5, Value<T6> v6, Value<T7> v7,
                                                                  Function7<T1, T2, T3, T4, T5, T6, T7, R> function) {
        return new ValueSupplier<>("zip7", () ->
                function.apply(v1.get(), v2.get(), v3.get(), v4.get(), v5.get(), v6.get(), v7.get()),
                v1, v2, v3, v4, v5, v6, v7);
    }

    static <T1, T2, T3, T4, T5, T6, T7, T8, R> Value<R> zip(Value<T1> v1, Value<T2> v2, Value<T3> v3, Value<T4> v4,
                                                                  Value<T5> v5, Value<T6> v6, Value<T7> v7, Value<T8> v8,
                                                                  Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function) {
        return new ValueSupplier<>("zip8", () ->
                function.apply(v1.get(), v2.get(), v3.get(), v4.get(), v5.get(), v6.get(), v7.get(), v8.get()),
                v1, v2, v3, v4, v5, v6, v7, v8);
    }

    static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Value<R> zip(Value<T1> v1, Value<T2> v2, Value<T3> v3, Value<T4> v4,
                                                                      Value<T5> v5, Value<T6> v6, Value<T7> v7, Value<T8> v8,
                                                                      Value<T9> v9, Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function) {
        return new ValueSupplier<>("zip9", () ->
                function.apply(v1.get(), v2.get(), v3.get(), v4.get(), v5.get(), v6.get(), v7.get(), v8.get(), v9.get()),
                v1, v2, v3, v4, v5, v6, v7, v8, v9);
    }

    static <T, R> Value<R> zip(Function<List<T>, R> function, Value<T>... values) {
        ValueSupplier<R> supplier = new ValueSupplier<>("zip array", () -> {
            List<T> results = new ArrayList<>(values.length);
            for(Value<T> v : values) {
                results.add(v.get());
            }
            return function.apply(results);
        });

        for(Value<T> v : values) {
            supplier.addDependentValue(v);
        }

        return supplier;
    }
}
