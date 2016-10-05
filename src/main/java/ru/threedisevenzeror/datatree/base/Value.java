package ru.threedisevenzeror.datatree.base;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public interface Value<T> {
    T get();
    void addOnValueChangedListener(OnValueChangedListener<T> listener);
    void removeOnValueChangedListener(OnValueChangedListener<T> listener);
}
