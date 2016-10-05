# Datatree
Тестовый фреймворк для описывания самообновляющегося дерева зависимостей между различными значениями

Позволяет выстраивать зависимые данные таким образом, что изменение оригинального значения, автоматически обновит все значения которые на него ссылаются.

В теории, получается удобная система, которой можно описать при помощи функций какие данные ожидаются при каких значениях, и изменяя данные генерировать эти значения на лету, получая уведомления о их изменении.

```java
VariableValue<Integer> count = new VariableValue<>(4);
VariableValue<Integer> treshold = new VariableValue<>(10);

StringValue title = new StringValue("Результат проверки: ")
    .concat(new IntegerValue(count).greaterThan(treshold).asCondition(
        new StringValue("%$1s определённо больше %$2s").format(count, treshold),
        new StringValue("%$1s не больше %$2s").format(count, treshold)));
        
// Результат проверки: 4 не больше 10
```

При изменении count или treshold, изменится и значение лежащее в title.
Если на title кто то повесил onValueChangedListener, изменение любого связанного объекта уведомит onValueChangedListener новым значением

На данный момент это всего лишь прототип, не более.
