package ru.threedisevenzeror.datatree.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public abstract class AbstractMutableValue<T> extends AbstractValue<T> {

    private List<OnValueChangedListener<T>> listeners;

    public void addOnValueChangedListener(OnValueChangedListener<T> listener) {
        if(listeners == null) {
            listeners = new ArrayList<>();
        }

        listeners.add(listener);
    }

    public void removeOnValueChangedListener(OnValueChangedListener<T> listener) {
        if(listeners != null) {
            listeners.remove(listener);
        }
    }

    protected boolean hasAttachedListeners() {
        return listeners != null && !listeners.isEmpty();
    }

    protected void notifyListeners(T prevValue, T nextValue) {
        if(listeners != null) {
            // TODO: Защита от отписки во время вызова

            for(int i = listeners.size() - 1; i >= 0; i--) {
                listeners.get(i).onValueChanged(prevValue, nextValue);
            }
        }
    }
}
