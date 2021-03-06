# Datatree
Тестовый фреймворк для описывания самообновляющегося дерева зависимостей между различными значениями

Позволяет выстраивать зависимые данные таким образом, что изменение оригинального значения, автоматически обновит все значения которые на него ссылаются.

В теории, получается удобная система, которой можно описать при помощи функций какие данные ожидаются при каких значениях, и изменяя данные генерировать эти значения на лету, получая уведомления о их изменении.

```java
String countString = "5";
Integer countInt = Integer.parse(countString);
String[] names = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten" };

if(countInt < names.length && countInt >= 0) {
    return "%1$s по английски?, легко, это \"%2$s!\""
            .format(countInt, names[countInt]);
} else {
    return "Извините, я не знаю как будет %1$s по английски, спросите что нибудь в диапазоне от 0 до %2$s"
            .format(countInt, names.length - 1);
}
```

Вышеописанная функция написанная на этой библиотеке

```java
VariableValue<String> countString = new VariableValue<>("5");

IntegerValue countInt = countString.asString().asNumber().asInteger().withNullValueAs(0);
ArrayValue<String> names = Value.constant("zero", "one", "two", "three", "four", "five","six", "seven", "eight", "nine", "ten");

StringValue text = countInt.isInBoundsInclusiveExclusive(Value.constant(0), names.count()).asCondition(
            Value.constant("%1$s по английски?, легко, это \"%2$s!\"")
                    .format(countInt, names.valueAt(countInt)),
            Value.constant("Извините, я не знаю как будет %1$s по английски, спросите что нибудь в диапазоне от 0 до %2$s")
                    .format(countInt, names.count().withFunction(v -> v - 1)))
        .debounce(TimeUnit.MILLISECONDS, 100)
        .asString();
```

При изменении count, изменится и значение лежащее в title. Если countString не удалось преобразовать в число, вместо него будет 0.
Если на title кто то повесил onValueChangedListener, изменение любого связанного объекта уведомит onValueChangedListener новым значением
Бонусом, debounce запретит обновление text'а если count меняется слишком часто, значение обновится только когда с момента последнего изменения пройдёт 250 мсек

На данный момент это всего лишь прототип, не более.
