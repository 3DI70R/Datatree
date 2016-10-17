package ru.threedisevenzeror.datatree.wrapper.collection;

import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.functional.ValueFunction;
import ru.threedisevenzeror.datatree.util.IndexedPredicate;
import ru.threedisevenzeror.datatree.wrapper.collection.base.ItemCollectionValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ThreeDISevenZeroR on 09.10.2016.
 */
public class MapValue<K, V> extends ItemCollectionValue<Map<K, V>, K, V> {

    public MapValue() {
    }

    public MapValue(Map<K, V> value) {
        super(value);
    }

    public MapValue(Value<Map<K, V>> value) {
        super(value);
    }

    @Override
    protected V getItemFromCollection(K key) {
        return get().get(key);
    }

    @Override
    protected boolean isKeyExists(K key) {
        return get().containsKey(key);
    }

    @Override
    protected int getCollectionCount() {
        return get().size();
    }

    @Override
    public MapValue<K, V> withNullValueAs(Map<K, V> nullValue) {
        return new MapValue<>(super.withNullValueAs(nullValue).getWrappedValue());
    }

    @Override
    public MapValue<K, V> withNullValueAs(Value<Map<K, V>> nullValue) {
        return new MapValue<>(super.withNullValueAs(nullValue).getWrappedValue());
    }

    @Override
    public MapValue<K, V> filter(IndexedPredicate<K, V> predicate) {
        return new MapValue<>(super.filter(predicate).getWrappedValue());
    }

    @Override
    public MapValue<K, V> filter(Value<IndexedPredicate<K, V>> predicate) {
        ValueFunction<Map<K, V>, Map<K, V>> func = new ValueFunction<>("filter", getWrappedValue(), v -> {
            if(v != null) {
                IndexedPredicate<K, V> p = predicate.get();
                if(p != null) {
                    Map<K, V> map = new HashMap<>();
                    for(Map.Entry<K, V> entry : v.entrySet()) {
                        if(p.test(entry.getKey(), entry.getValue())) {
                            map.put(entry.getKey(), entry.getValue());
                        }
                    }
                    return map;
                }
            }

            return null;
        });
        func.addDependentValue(predicate);
        return new MapValue<>(func);
    }
}
