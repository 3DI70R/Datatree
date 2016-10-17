package ru.threedisevenzeror.datatree.wrapper.bool;

import com.sun.org.apache.xpath.internal.operations.Bool;
import ru.threedisevenzeror.datatree.base.ReferenceValue;
import ru.threedisevenzeror.datatree.base.Value;

/**
 * Created by ThreeDISevenZeroR on 17.10.16.
 */
public class BooleanReferenceValue<V extends Value<Boolean>>
        extends BooleanValue implements ReferenceValue<V,Boolean> {

    @Override
    public void setReference(V value) {
        setWrappedValue(value);
    }

    @Override
    public V getReference() {
        return (V) getWrappedValue();
    }
}
