package ru.threedisevenzeror.datatree.base;

/**
 * Created by ThreeDISevenZeroR on 08.10.2016.
 */
public interface ReferenceValue<V extends Value<? extends T>, T> extends Value<T> {
    void setReference(V value);
    void setConstant(T value);
    V getReference();
}
