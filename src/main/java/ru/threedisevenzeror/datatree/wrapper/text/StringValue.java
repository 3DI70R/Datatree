package ru.threedisevenzeror.datatree.wrapper.text;

import ru.threedisevenzeror.datatree.base.ConstantValue;
import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.functional.ValueFunction;
import ru.threedisevenzeror.datatree.wrapper.ObjectValue;
import ru.threedisevenzeror.datatree.wrapper.bool.BooleanValue;
import ru.threedisevenzeror.datatree.wrapper.number.NumberValue;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class StringValue extends TextValue<String> {

    public StringValue() {

    }

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
        ValueFunction<String, Boolean> func = new ValueFunction<>("contains", getWrappedValue(), s -> {
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
        ValueFunction<String, String> func = new ValueFunction<>("concat", getWrappedValue(), s -> {
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
        return new StringValue(new ValueFunction<>("trim", getWrappedValue(), v -> v != null ? v.trim() : null));
    }

    public StringValue toLowerCase() {
        return toLowerCase(Locale.getDefault());
    }

    public StringValue toLowerCase(Locale locale) {
        return toLowerCase(new ConstantValue<>(locale));
    }

    public StringValue toLowerCase(Value<Locale> locale) {
        ValueFunction<String, String> func = new ValueFunction<>("toLowerCase", getWrappedValue(),
                s -> s != null ? s.toLowerCase(locale.get()) : null);
        func.addDependentValue(locale);
        return new StringValue(func);
    }

    public StringValue toUpperCase() {
        return toUpperCase(Locale.getDefault());
    }

    public StringValue toUpperCase(Locale locale) {
        return toUpperCase(new ConstantValue<>(locale));
    }

    public StringValue toUpperCase(Value<Locale> locale) {
        ValueFunction<String, String> func = new ValueFunction<>("toUpperCase", getWrappedValue(),
                s -> s != null ? s.toUpperCase(locale.get()) : null);
        func.addDependentValue(locale);
        return new StringValue(func);
    }

    public BooleanValue equalsIgnoreCase(String value) {
        return equalsIgnoreCase(new ConstantValue<>(value));
    }

    public BooleanValue equalsIgnoreCase(Value<String> value) {
        ValueFunction<String, Boolean> func = new ValueFunction<>("equalsIgnoreCase", getWrappedValue(),
                s -> s != null ? s.equalsIgnoreCase(value.get()) : null);
        func.addDependentValue(value);
        return new BooleanValue(func);
    }

    public StringValue format(Object... args) {
        return format(Locale.getDefault(), args);
    }

    public StringValue format(Locale locale, Object... args) {
        Value<?>[] valueArgs = new Value[args.length];

        for(int i = 0; i < args.length; i++) {
            valueArgs[i] = new ConstantValue<>(args[i]);
        }

        return format(new ConstantValue<>(locale), valueArgs);
    }

    public StringValue format(Value<?>... args) {
        return format(new ConstantValue<>(Locale.getDefault()), args);
    }

    public StringValue format(Value<Locale> locale, Value<?>... args) {
        ValueFunction<String, String> func = new ValueFunction<>("format", getWrappedValue(), s -> {
            if (s != null) {
                Object[] argObjects = new Object[args.length];

                for(int i = 0; i < args.length; i++) {
                    argObjects[i] = args[i].get();
                }

                return String.format(locale.get(), s, argObjects);
            } else {
                return null;
            }
        });

        func.addDependentValue(locale);
        for(Value<?> v : args) {
            func.addDependentValue(v);
        }

        return new StringValue(func);
    }

    public NumberValue<?> asNumber() {
        return new NumberValue<>(new ValueFunction<>("asNumber", getWrappedValue(), (String v) -> {
            try {
                return NumberFormat.getNumberInstance().parse(v);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return null;
        }));
    }

    @Override
    public StringValue updateOn(Executor nullValue) {
        return new StringValue(super.updateOn(nullValue).getWrappedValue());
    }

    @Override
    public StringValue updateOn(Value<? extends Executor> value) {
        return new StringValue(super.updateOn(value).getWrappedValue());
    }

    @Override
    public StringValue withNullValueAs(String nullValue) {
        return new StringValue(super.withNullValueAs(nullValue).getWrappedValue());
    }

    @Override
    public StringValue withNullValueAs(Value<String> value) {
        return new StringValue(super.withNullValueAs(value).getWrappedValue());
    }

    @Override
    public StringValue debounce(Value<TimeUnit> timeUnit, Value<Long> time) {
        return new StringValue(super.debounce(timeUnit, time).getWrappedValue());
    }

    @Override
    public StringValue debounce(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new StringValue(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public StringValue debounce(TimeUnit timeUnit, long time) {
        return new StringValue(super.debounce(timeUnit, time).getWrappedValue());
    }

    @Override
    public StringValue debounce(Executor executor, TimeUnit timeUnit, long time) {
        return new StringValue(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public StringValue delay(Value<TimeUnit> timeUnit, Value<Long> time) {
        return new StringValue(super.delay(timeUnit, time).getWrappedValue());
    }

    @Override
    public StringValue delay(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new StringValue(super.delay(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public StringValue delay(TimeUnit timeUnit, long time) {
        return new StringValue(super.delay(timeUnit, time).getWrappedValue());
    }

    @Override
    public StringValue delay(Executor executor, TimeUnit timeUnit, long time) {
        return new StringValue(super.delay(executor, timeUnit, time).getWrappedValue());
    }
}
