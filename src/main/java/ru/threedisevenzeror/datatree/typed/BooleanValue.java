package ru.threedisevenzeror.datatree.typed;

import com.sun.javafx.fxml.expression.ExpressionValue;
import ru.threedisevenzeror.datatree.base.AbstractDependentValue;
import ru.threedisevenzeror.datatree.base.ConstantValue;
import ru.threedisevenzeror.datatree.base.Value;
import ru.threedisevenzeror.datatree.base.ValueFunction;
import ru.threedisevenzeror.datatree.typed.number.NumberValue;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created by ThreeDISevenZeroR on 05.10.2016.
 */
public class BooleanValue extends ObjectValue<Boolean> {

    public BooleanValue(Boolean value) {
        this(new ConstantValue<>(value));
    }

    public BooleanValue(Value<Boolean> value) {
        super(value);
    }

    public BooleanValue not() {
        return new BooleanValue(new ValueFunction<>(getWrappedValue(), b -> b != null ? !b : null));
    }

    public NumberValue<?> asNumber() {
        return new NumberValue<>(new ValueFunction<>(getWrappedValue(), b -> b != null ? (b ? 1 : 0) : null));
    }

    @Override
    public BooleanValue debounce(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new BooleanValue(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public BooleanValue debounce(Executor executor, TimeUnit timeUnit, long time) {
        return new BooleanValue(super.debounce(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public BooleanValue delay(Value<? extends Executor> executor, Value<TimeUnit> timeUnit, Value<Long> time) {
        return new BooleanValue(super.delay(executor, timeUnit, time).getWrappedValue());
    }

    @Override
    public BooleanValue delay(Executor executor, TimeUnit timeUnit, long time) {
        return new BooleanValue(super.delay(executor, timeUnit, time).getWrappedValue());
    }

    public <T> ObjectValue<T> asCondition(T trueValue,
                                          T falseValue) {
        return asCondition(trueValue, falseValue, null);
    }

    public <T> ObjectValue<T> asCondition(T trueValue,
                                          T falseValue,
                                          T nullValue) {
        return new ObjectValue<>(new ValueFunction<>(getWrappedValue(), b -> {
            if(b != null) {
                return b ? trueValue : falseValue;
            } else {
                return nullValue;
            }
        }));
    }

    public <T> ObjectValue<T> asCondition(Value<? extends T> trueValue,
                                          Value<? extends T> falseValue) {
        return asCondition(trueValue, falseValue, new ConstantValue<>(null));
    }

    public <T> ObjectValue<T> asCondition(Value<? extends T> trueValue,
                                    Value<? extends T> falseValue,
                                    Value<? extends T> nullValue) {
        ValueFunction<Boolean, T> value = new ValueFunction<>(getWrappedValue(), b -> {
            if(b != null) {
                return b ? trueValue.get() : falseValue.get();
            } else {
                return nullValue.get();
            }
        });
        value.addDependentValue(trueValue);
        value.addDependentValue(falseValue);
        value.addDependentValue(nullValue);

        return new ObjectValue<>(value);
    }
}
