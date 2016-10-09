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
        values = new ArrayList<>(2);
        sharedListener = (prevValue, newValue) -> {
            onDependentValueUpdated();
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
        if(shouldRegister) {
            for(Value<? extends V> value : values) {
                value.addOnValueChangedListener(sharedListener);
            }
        }
    }

    @Override
    public void removeOnValueChangedListener(OnValueChangedListener<T> listener) {
        super.removeOnValueChangedListener(listener);
        if(!hasAttachedListeners()) {
            for(Value<? extends V> value : values) {
                value.removeOnValueChangedListener(sharedListener);
            }
        }
    }

    @Override
    public T get() {
        if(hasAttachedListeners()) {
            return currentValue;
        } else {
            return getNewValue();
        }
    }

    protected abstract T getNewValue();

    protected void onDependentValueUpdated() {
        updateValue();
    }

    protected void updateValue() {
        T newValue = getNewValue();
        if(isObjectsDiffers(currentValue, newValue)) {
            T oldValue = currentValue;
            currentValue = newValue;
            notifyListeners(oldValue, currentValue);
        }
    }

    protected boolean isObjectsDiffers(T left, T right) {
        return !Objects.equals(left, right);
    }

    public List<Value<? extends V>> getDependentValues() {
        if(values != null) {
            return Collections.unmodifiableList(values);
        } else {
            return Collections.emptyList();
        }
    }
}
