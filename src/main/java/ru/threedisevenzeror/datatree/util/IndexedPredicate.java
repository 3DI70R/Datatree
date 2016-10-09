package ru.threedisevenzeror.datatree.util;

/**
 * Created by ThreeDISevenZeroR on 09.10.2016.
 */
public interface IndexedPredicate<K, V> {
    boolean test(K key, V value);
}
