package ru.threedisevenzeror.datatree.base;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 *
 * Listener на обновление
 */
public interface OnValueChangedListener<T> {

    /**
     * Метод вызываемый при событии изменения значения
     * @param prevValue предыдущее значение, которое находилось в Value до изменения
     * @param newValue новое значение, которое теперь хранится в этом Value
     */
    void onValueChanged(T prevValue, T newValue);
}
