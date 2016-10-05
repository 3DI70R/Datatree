package ru.threedisevenzeror.datatree.base;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public abstract class AbstractValue<T> implements Value<T> {

    @Override
    public String toString() {
        T value = get();

        if(value != null) {
            return value.toString();
        } else {
            return null;
        }
    }
}
