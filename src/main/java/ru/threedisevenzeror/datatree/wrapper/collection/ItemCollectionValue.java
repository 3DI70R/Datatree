package ru.threedisevenzeror.datatree.wrapper.collection;

import ru.threedisevenzeror.datatree.base.ConstantValue;
import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.functional.ValueFunction;
import ru.threedisevenzeror.datatree.base.functional.ValueSupplier;
import ru.threedisevenzeror.datatree.util.IndexedPredicate;
import ru.threedisevenzeror.datatree.wrapper.ObjectValue;
import ru.threedisevenzeror.datatree.wrapper.number.ByteValue;
import ru.threedisevenzeror.datatree.wrapper.number.IntegerValue;

/**
 * Created by ThreeDISevenZeroR on 09.10.2016.
 */
public abstract class ItemCollectionValue<C, K, V> extends ObjectValue<C> {

    public ItemCollectionValue() {
    }

    public ItemCollectionValue(C value) {
        super(value);
    }

    public ItemCollectionValue(Value<C> value) {
        super(value);
    }

    protected abstract V getItemFromCollection(K key);
    protected abstract boolean isKeyExists(K key);
    protected abstract int getCollectionCount();

    public IntegerValue count() {
        ValueSupplier<Integer> supplier = new ValueSupplier<>("count", this::getCollectionCount);
        supplier.addDependentValue(this);
        return new IntegerValue(supplier);
    }

    public ObjectValue<V> valueAt(K index) {
        return valueAt(Value.constant(index));
    }

    public ObjectValue<V> valueAt(Value<K> index) {
        ValueFunction<K, V> supplier = new ValueFunction<>("valueAt", index, v -> {
            if(isKeyExists(v)) {
                return getItemFromCollection(v);
            } else {
                return null;
            }
        });
        supplier.addDependentValue(this);
        return new ObjectValue<>(supplier);
    }

    public ItemCollectionValue<C, K, V> filter(IndexedPredicate<K, V> predicate) {
        return filter(Value.constant(predicate));
    }

    public abstract ItemCollectionValue<C, K, V> filter(Value<IndexedPredicate<K, V>> predicate);
}
