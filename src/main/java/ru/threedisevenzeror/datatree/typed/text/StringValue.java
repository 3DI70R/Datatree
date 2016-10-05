package ru.threedisevenzeror.datatree.typed.text;

import ru.threedisevenzeror.datatree.base.ConstantValue;
import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.ValueFunction;
import ru.threedisevenzeror.datatree.typed.BooleanValue;
import ru.threedisevenzeror.datatree.typed.number.NumberValue;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class StringValue extends TextValue<String> {

    public StringValue(String value) {
        this(new ConstantValue<>(value));
    }

    public StringValue(Value<String> value) {
        super(value);
    }

    @Override
    public StringValue asString() {
        return this;
    }

    public BooleanValue contains(CharSequence text) {
        return contains(new ConstantValue<>(text));
    }

    public BooleanValue contains(Value<? extends CharSequence> text) {
        ValueFunction<String, Boolean> func = new ValueFunction<>(getWrappedValue(), s -> {
            if(s != null) {
                CharSequence textObject = text.get();
                if(textObject != null) {
                    return s.contains(textObject);
                }
            }

            return false;
        });
        func.addDependentValue(text);

        return new BooleanValue(func);
    }

    public StringValue concat(String text) {
        return concat(new ConstantValue<>(text));
    }

    public StringValue concat(Value<String> text) {
        ValueFunction<String, String> func = new ValueFunction<>(getWrappedValue(), s -> {
            String otherValue = text.get();
            if(s != null) {
                if(otherValue != null) {
                    return s.concat(otherValue);
                } else {
                    return s;
                }
            } else {
                return null;
            }
        });
        func.addDependentValue(text);
        return new StringValue(func);
    }

    public StringValue trim() {
        return new StringValue(new ValueFunction<>(getWrappedValue(), v -> v != null ? v.trim() : null));
    }

    public StringValue toLowerCase() {
        return new StringValue(new ValueFunction<>(getWrappedValue(), v -> v != null ? v.toLowerCase() : null));
    }

    public StringValue toLowerCase(Locale locale) {
        return toLowerCase(new ConstantValue<>(locale));
    }

    public StringValue toLowerCase(Value<Locale> locale) {
        ValueFunction<String, String> func = new ValueFunction<>(getWrappedValue(),
                s -> s != null ? s.toLowerCase(locale.get()) : null);
        func.addDependentValue(locale);
        return new StringValue(func);
    }

    public StringValue toUpperCase() {
        return new StringValue(new ValueFunction<>(getWrappedValue(), v -> v != null ? v.toUpperCase() : null));
    }

    public StringValue toUpperCase(Locale locale) {
        return toUpperCase(new ConstantValue<>(locale));
    }

    public StringValue toUpperCase(Value<Locale> locale) {
        ValueFunction<String, String> func = new ValueFunction<>(getWrappedValue(),
                s -> s != null ? s.toUpperCase(locale.get()) : null);
        func.addDependentValue(locale);
        return new StringValue(func);
    }

    public BooleanValue equalsIgnoreCase(String value) {
        return equalsIgnoreCase(new ConstantValue<>(value));
    }

    public BooleanValue equalsIgnoreCase(Value<String> value) {
        ValueFunction<String, Boolean> func = new ValueFunction<>(getWrappedValue(),
                s -> s != null ? s.equalsIgnoreCase(value.get()) : null);
        func.addDependentValue(value);
        return new BooleanValue(func);
    }

    public NumberValue<?> asNumber() {
        return new NumberValue<>(new ValueFunction<>(getWrappedValue(), (String v) -> {
            try {
                return NumberFormat.getNumberInstance().parse(v);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return null;
        }));
    }
}
