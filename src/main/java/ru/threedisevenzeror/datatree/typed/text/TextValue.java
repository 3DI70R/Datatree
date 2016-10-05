package ru.threedisevenzeror.datatree.typed.text;

import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.ValueFunction;
import ru.threedisevenzeror.datatree.typed.ObjectValue;
import ru.threedisevenzeror.datatree.typed.number.IntegerValue;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class TextValue<T extends CharSequence> extends ObjectValue<T> {

    public TextValue(Value<T> value) {
        super(value);
    }

    public IntegerValue length() {
        return new IntegerValue(new ValueFunction<>(getWrappedValue(), v -> v != null ? v.length() : 0));
    }
}
