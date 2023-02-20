package homework.service.string;

import java.util.Arrays;

public class StringApplication {
    public static void main(String[] args) {

        StringArrayListImpl stringList = new StringArrayListImpl();

        /*проверяем какой размер списка при создании*/
        System.out.println(stringList.size());
        System.out.println(stringList);

    /*добавляем элементы в список,
    проверяем возвращает ли метод add() вставленную строку,
    проверяем корректно ли работает метод size(),
    проверяем добавлились ли элементы в ArrayList*/
        System.out.println(stringList.add("Привет"));
        stringList.add("Сегодня");
        stringList.add("солнечный");
        stringList.add("день");
        System.out.println(stringList.size());
        System.out.println(stringList);

    /*добавляем элемент в список по индексу,
    проверяем возвращает ли метод add() вставленную строку,
    проверяем корректно ли работает выброс исключения метода add()*/
        System.out.println(stringList.add(3, "день"));
        System.out.println(stringList.size());
        System.out.println(stringList);

    /*вставляем элемент в список по индексу,
    проверяем корректно ли работает выброс исключения метода set()*/
        stringList.set(2, "снег");
        System.out.println(stringList);

    /*удаляем элемент из списка,
    проверяем возвращает ли метод remove() удаленную строку,
    проверяем корректно ли работает выброс исключения метода remove()*/
        String day = "день";
        System.out.println(stringList.remove(day));
        String sun = "солнце";
        System.out.println(stringList.size());
        System.out.println(stringList);

    /*удаляем элемент из списка по индексу,
    проверяем возвращает ли метод remove() удаленную строку
    проверяем корректно ли работает выброс исключения метода remove()*/
        System.out.println(stringList.remove(5));
        System.out.println(stringList.remove(3));
        System.out.println(stringList.size());
        System.out.println(stringList);

        /*проверяем наличие элемента в списке*/
        String rain = "дождь";
        System.out.println(stringList.contains(rain));
        String today = "сегодня";
        System.out.println(stringList.contains(today));

        /*ищем элемент в списке*/
        System.out.println(stringList.indexOf(rain));
        System.out.println(stringList.indexOf(today));

        /*ищем элемент в списке с конца*/
        String hello = "Привет";
        System.out.println(stringList.lastIndexOf(hello));
        System.out.println(stringList.lastIndexOf(sun));

    /*получяем элемент из списка по индексу,
    проверяем корректно ли работает выброс исключения метода get()*/
        System.out.println(stringList.get(1));

    /*сравниваем текущий список с другим,
    проверяем корректно ли работает выброс исключения метода equals()*/
        StringArrayListImpl stringList2 = new StringArrayListImpl();
        stringList2.add("Цветы");
        System.out.println(stringList2.equals(stringList));

        stringList2.remove("Цветы");
        stringList2.add("Привет");
        stringList2.add("Сегодня");
        stringList2.add("Дождь");
        stringList2.add("И");
        System.out.println(stringList2.equals(stringList));

        /*создаем новый массив из элементов списка*/
//        System.out.println(Arrays.toString(stringList.toArray());

        /*удаляем все элементы из списка*/
        stringList.clear();
        System.out.println(stringList.size());
        System.out.println(stringList);

        /*проверяем пустой ли список*/
        System.out.println(stringList2.isEmpty());
        System.out.println(stringList.isEmpty());
    }
}
