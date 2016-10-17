package ru.threedisevenzeror.datatree.wrapper.collection;

import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.functional.ValueFunction;
import ru.threedisevenzeror.datatree.util.Function;
import ru.threedisevenzeror.datatree.util.IndexedPredicate;
import ru.threedisevenzeror.datatree.wrapper.collection.base.ItemCollectionValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ThreeDISevenZeroR on 09.10.2016.
 */
public class ListValue<T> extends ItemCollectionValue<List<T>, Integer, T> {

    public ListValue() {
    }

    public ListValue(List<T> value) {
        super(value);
    }

    public ListValue(Value<List<T>> value) {
        super(value);
    }

    @Override
    protected T getItemFromCollection(Integer key) {
        return get().get(key);
    }

    @Override
    protected boolean isKeyExists(Integer key) {
        return key != null && key >= 0 && key < getCollectionCount();
    }

    @Override
    protected int getCollectionCount() {
        List<T> l = get();
        return l != null ? l.size() : 0;
    }

    @Override
    public ListValue<T> withNullValueAs(List<T> nullValue) {
        return new ListValue<>(super.withNullValueAs(nullValue).getWrappedValue());
    }

    @Override
    public ListValue<T> withNullValueAs(Value<List<T>> value) {
        return new ListValue<>(super.withNullValueAs(value).getWrappedValue());
    }

    @Override
    public ListValue<T> filter(IndexedPredicate<Integer, T> predicate) {
        return new ListValue<>(super.filter(predicate).getWrappedValue());
    }

    @Override
    public ListValue<T> filter(Value<IndexedPredicate<Integer, T>> predicate) {
        ValueFunction<List<T>, List<T>> func = new ValueFunction<>("filter", getWrappedValue(), v -> {
            if(v != null) {
                IndexedPredicate<Integer, T> p = predicate.get();
                if(p != null) {
                    List<T> newList = new ArrayList<>();
                    for(int i = 0; i < v.size(); i++) {
                        T obj = v.get(i);
                        if(p.test(i, obj)) {
                            newList.add(obj);
                        }
                    }
                    return newList;
                }
            }

            return null;
        });
        func.addDependentValue(predicate);
        return new ListValue<>(func);
    }

    public <N> ListValue<N> map(Function<T, N> function) {
        return map(Value.constant(function));
    }

    public <N> ListValue<N> map(Value<Function<T, N>> function) {
        ValueFunction<List<T>, List<N>> value = new ValueFunction<>("map", getWrappedValue(), v -> {
            if(v != null) {
                Function<T, N> f = function.get();
                if(f != null) {
                    List<N> items = new ArrayList<>();
                    for(int i = 0; i < v.size(); i++) {
                        items.add(f.apply(v.get(i)));
                    }
                    return items;
                }
            }
            return null;
        });
        value.addDependentValue(function);
        return new ListValue<>(value);
    }
}
