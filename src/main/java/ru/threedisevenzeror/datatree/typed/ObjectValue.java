package ru.threedisevenzeror.datatree.typed;

import ru.threedisevenzeror.datatree.base.AbstractValueWrapper;
import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.ValueFunction;
import ru.threedisevenzeror.datatree.typed.text.StringValue;

import java.util.Objects;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class ObjectValue<T> extends AbstractValueWrapper<T> {

    public ObjectValue(Value<T> value) {
        super(value);
    }

    public StringValue asString() {
        return new StringValue(new ValueFunction<>(getWrappedValue(), v -> v != null ? v.toString() : null));
    }

    public BooleanValue notEquals(Value<?> obj) {
        return new BooleanValue(new ValueFunction<>(obj, f -> !Objects.equals(f, get())));
    }

    public BooleanValue equals(Value<?> obj) {
        return new BooleanValue(new ValueFunction<>(obj, f -> Objects.equals(f, get())));
    }
}
