# Datatree
Тестовый фреймворк для описывания самообновляющегося дерева зависимостей между различными значениями

Позволяет выстраивать зависимые данные таким образом, что изменение оригинального значения, автоматически обновит все значения которые на него ссылаются.

В теории, получается удобная система, которой можно описать при помощи функций какие данные ожидаются при каких значениях, и изменяя данные генерировать эти значения на лету, получая уведомления о их изменении.

```java
VariableValue<String> countString = new VariableValue<>("5");

IntegerValue countInt = new StringValue(countString)
    .asNumber().asInteger().withNullValueAs(0);

ArrayValue<String> names = new ArrayValue<>(
    "zero", "one", "two", "three", "four", "five",
    "six", "seven", "eight", "nine", "ten");

Value<String> text = (countInt.lessThan(names.count())).and(countInt.greaterThanOrEquals(0)).asCondition(
            new StringValue("%1$s по английски?, легко, это \"%2$s!\"")
                    .format(countInt, names.valueAt(countInt)),
            new StringValue("Извините, я не знаю как будет %1$s по английски, спросите что нибудь в диапазоне от 0 до %2$s")
                    .format(countInt, names.count().withFunction(v -> v - 1)))
        .debounce(TimeUnit.MILLISECONDS, 100);

text.addOnValueChangedListener((prevValue, newValue) ->
        System.out.println(newValue));

BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

while (true) {
    countString.set(reader.readLine());
}
```

При изменении count или treshold, изменится и значение лежащее в title.
Если на title кто то повесил onValueChangedListener, изменение любого связанного объекта уведомит onValueChangedListener новым значением

На данный момент это всего лишь прототип, не более.
