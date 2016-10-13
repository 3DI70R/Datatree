package ru.threedisevenzeror.datatree.wrapper.collection;

import ru.threedisevenzeror.datatree.base.ConstantValue;
import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.functional.ValueFunction;
import ru.threedisevenzeror.datatree.util.IndexedPredicate;
import ru.threedisevenzeror.datatree.wrapper.ObjectValue;
import ru.threedisevenzeror.datatree.wrapper.bool.BooleanValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * Created by ThreeDISevenZeroR on 09.10.2016.
 */
public class ArrayValue<T> extends ItemCollectionValue<T[], Integer, T> {

    public ArrayValue() {
    }

    @SafeVarargs
    public ArrayValue(T... value) {
        super(value);
    }

    public ArrayValue(Value<T[]> value) {
        super(value);
    }

    @Override
    protected T getItemFromCollection(Integer key) {
        return get()[key];
    }

    @Override
    protected boolean isKeyExists(Integer key) {
        return key != null && key >= 0 && key < getCollectionCount();
    }

    @Override
    protected int getCollectionCount() {
        return get().length;
    }

    @Override
    protected boolean isObjectsDiffers(T[] left, T[] right) {
        return !Arrays.equals(left, right);
    }

    @Override
    public ArrayValue<T> updateOn(Executor nullValue) {
        return new ArrayValue<>(super.updateOn(nullValue).getWrappedValue());
    }

    @Override
    public ArrayValue<T> updateOn(Value<? extends Executor> value) {
        return new ArrayValue<>(super.updateOn(value).getWrappedValue());
    }

    @Override
    public ArrayValue<T> withNullValueAs(T[] nullValue) {
        return new ArrayValue<>(super.withNullValueAs(nullValue).getWrappedValue());
    }

    @Override
    public ArrayValue<T> withNullValueAs(Value<T[]> value) {
        return new ArrayValue<>(super.withNullValueAs(value).getWrappedValue());
    }

    @Override
    public ArrayValue<T> filter(IndexedPredicate<Integer, T> predicate) {
        return filter(new ConstantValue<>(predicate));
    }

    @Override
    public ArrayValue<T> filter(Value<IndexedPredicate<Integer, T>> predicate) {
        ValueFunction<T[], T[]> function = new ValueFunction<>("filter", getWrappedValue(), f -> {
            if(f != null) {
                IndexedPredicate<Integer, T> p = predicate.get();
                if(p != null) {
                    List<T> list = new ArrayList<>();
                    for(int i = 0; i < f.length; i++) {
                        if(p.test(i, f[i])) {
                            list.add(f[i]);
                        }
                    }
                    return list.toArray(Arrays.copyOf(f, list.size()));
                }
            }
            return null;
        });
        function.addDependentValue(predicate);
        return new ArrayValue<>(function);
    }
}
