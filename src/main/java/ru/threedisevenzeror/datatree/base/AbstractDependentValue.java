package ru.threedisevenzeror.datatree.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public abstract class AbstractDependentValue<T, V> extends AbstractMutableValue<T> {

    private List<Value<? extends V>> values;
    private OnValueChangedListener sharedListener;
    private T currentValue;

    public AbstractDependentValue() {
        sharedListener = (prevValue, newValue) -> {
            updateValue();
        };
    }

    protected void addDependentValue(Value<? extends V> value) {
        if(values == null) {
            values = new ArrayList<>();
        }

        if(hasAttachedListeners()) {
            value.addOnValueChangedListener(sharedListener);
        }

        values.add(value);
        updateValue();
    }

    protected void removeDependentValue(Value<? extends V> value) {
        if(values != null) {
            values.remove(value);
        }

        value.removeOnValueChangedListener(sharedListener);
        updateValue();
    }

    @Override
    public void addOnValueChangedListener(OnValueChangedListener<T> listener) {
        boolean shouldRegister = !hasAttachedListeners();
        super.addOnValueChangedListener(listener);

        if(shouldRegister && values != null) {
            for(Value<? extends V> value : values) {
                value.addOnValueChangedListener(sharedListener);
            }
        }
    }

    @Override
    public void removeOnValueChangedListener(OnValueChangedListener<T> listener) {
        super.removeOnValueChangedListener(listener);

        if(!hasAttachedListeners() && values != null) {
            for(Value<? extends V> value : values) {
                value.removeOnValueChangedListener(sharedListener);
            }
        }
    }

    @Override
    public T get() {
        if(hasAttachedListeners()) {
            return getNewValue();
        } else {
            return currentValue;
        }
    }

    protected abstract T getNewValue();

    protected void updateValue() {
        T newValue = getNewValue();


        if(!Objects.equals(currentValue, newValue)) {
            T oldValue = currentValue;
            currentValue = newValue;
            notifyListeners(oldValue, currentValue);
        }
    }

    public List<Value<? extends V>> getDependentValues() {
        if(values != null) {
            return Collections.unmodifiableList(values);
        } else {
            return Collections.emptyList();
        }
    }
}
