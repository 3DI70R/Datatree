package ru.threedisevenzeror.datatree.base;

import ru.threedisevenzeror.datatree.base.functional.ValueSupplier;
import ru.threedisevenzeror.datatree.util.*;
import ru.threedisevenzeror.datatree.wrapper.ObjectValue;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public interface Value<T> {

    T get();
    void addOnValueChangedListener(OnValueChangedListener<T> listener);
    void removeOnValueChangedListener(OnValueChangedListener<T> listener);


    static <T1, T2, R> ObjectValue<R> zip(Value<T1> v1, Value<T2> v2, Function2<T1, T2, R> function) {
        return new ObjectValue<>(new ValueSupplier<>(() ->
                function.apply(v1.get(), v2.get()),
                v1, v2));
    }

    static <T1, T2, T3, R> ObjectValue<R> zip(Value<T1> v1, Value<T2> v2, Value<T3> v3, Function3<T1, T2, T3, R> function) {
        return new ObjectValue<>(new ValueSupplier<>(() ->
                function.apply(v1.get(), v2.get(), v3.get()),
                v1, v2, v3));
    }

    static <T1, T2, T3, T4, R> ObjectValue<R> zip(Value<T1> v1, Value<T2> v2, Value<T3> v3, Value<T4> v4, Function4<T1, T2, T3, T4, R> function) {
        return new ObjectValue<>(new ValueSupplier<>(() ->
                function.apply(v1.get(), v2.get(), v3.get(), v4.get()),
                v1, v2, v3, v4));
    }

    static <T1, T2, T3, T4, T5, R> ObjectValue<R> zip(Value<T1> v1, Value<T2> v2, Value<T3> v3, Value<T4> v4,
                                                          Value<T5> v5, Function5<T1, T2, T3, T4, T5, R> function) {
        return new ObjectValue<>(new ValueSupplier<>(() ->
                function.apply(v1.get(), v2.get(), v3.get(), v4.get(), v5.get()),
                v1, v2, v3, v4, v5));
    }

    static <T1, T2, T3, T4, T5, T6, R> ObjectValue<R> zip(Value<T1> v1, Value<T2> v2, Value<T3> v3, Value<T4> v4,
                                                              Value<T5> v5, Value<T6> v6, Function6<T1, T2, T3, T4, T5, T6, R> function) {
        return new ObjectValue<>(new ValueSupplier<>(() ->
                function.apply(v1.get(), v2.get(), v3.get(), v4.get(), v5.get(), v6.get()),
                v1, v2, v3, v4, v5, v6));
    }

    static <T1, T2, T3, T4, T5, T6, T7, R> ObjectValue<R> zip(Value<T1> v1, Value<T2> v2, Value<T3> v3, Value<T4> v4,
                                                                  Value<T5> v5, Value<T6> v6, Value<T7> v7,
                                                                  Function7<T1, T2, T3, T4, T5, T6, T7, R> function) {
        return new ObjectValue<>(new ValueSupplier<>(() ->
                function.apply(v1.get(), v2.get(), v3.get(), v4.get(), v5.get(), v6.get(), v7.get()),
                v1, v2, v3, v4, v5, v6, v7));
    }

    static <T1, T2, T3, T4, T5, T6, T7, T8, R> ObjectValue<R> zip(Value<T1> v1, Value<T2> v2, Value<T3> v3, Value<T4> v4,
                                                                  Value<T5> v5, Value<T6> v6, Value<T7> v7, Value<T8> v8,
                                                                  Function8<T1, T2, T3, T4, T5, T6, T7, T8, R> function) {
        return new ObjectValue<>(new ValueSupplier<>(() ->
                function.apply(v1.get(), v2.get(), v3.get(), v4.get(), v5.get(), v6.get(), v7.get(), v8.get()),
                v1, v2, v3, v4, v5, v6, v7, v8));
    }

    static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> ObjectValue<R> zip(Value<T1> v1, Value<T2> v2, Value<T3> v3, Value<T4> v4,
                                                                      Value<T5> v5, Value<T6> v6, Value<T7> v7, Value<T8> v8,
                                                                      Value<T9> v9, Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> function) {
        return new ObjectValue<>(new ValueSupplier<>(() ->
                function.apply(v1.get(), v2.get(), v3.get(), v4.get(), v5.get(), v6.get(), v7.get(), v8.get(), v9.get()),
                v1, v2, v3, v4, v5, v6, v7, v8, v9));
    }

    static <T, R> ObjectValue<R> zip(Function<List<T>, R> function, Value<T>... values) {
        ValueSupplier<R> supplier = new ValueSupplier<>(() -> {
            List<T> results = new ArrayList<>(values.length);
            for(Value<T> v : values) {
                results.add(v.get());
            }
            return function.apply(results);
        });

        for(Value<T> v : values) {
            supplier.addDependentValue(v);
        }

        return new ObjectValue<>(supplier);
    }
}
