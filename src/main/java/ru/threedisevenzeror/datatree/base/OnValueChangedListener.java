package ru.threedisevenzeror.datatree.base;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public interface OnValueChangedListener<T> {
    void onValueChanged(T prevValue, T newValue);
}
