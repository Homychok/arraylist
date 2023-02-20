package homework.service.integer;

import homework.service.CheckSortingTime;

import java.util.Arrays;

public class IntegerApplication {
    public static void main(String[] args) {

        IntegerArrayListImpl integerList = new IntegerArrayListImpl();

        /*проверяем какой размер списка при создании*/
        System.out.println(integerList.size());
        System.out.println(integerList);

    /*добавляем элементы в список,
    проверяем возвращает ли метод add() вставленное число,
    проверяем как работает выбранный нами способ сортировки,
    проверяем корректно ли работает метод size(),
    проверяем добавлились ли элементы в ArrayList*/
        System.out.println(integerList.add(10));
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        System.out.println(Arrays.toString(CheckSortingTime.selectionSort(integerList.toArray())));
        System.out.println(integerList.size());
        System.out.println(integerList);

    /*добавляем элемент в список по индексу,
    проверяем возвращает ли метод add() вставленное число,
    проверяем корректно ли работает выброс исключения метода add()*/
        System.out.println(integerList.add(2, 0));
        System.out.println(integerList.size());
        System.out.println(integerList);

    /*вставляем элемент в список по индексу,
    проверяем корректно ли работает выброс исключения метода set()*/
        integerList.set(2, 33);
        System.out.println(integerList);

    /*удаляем элемент из списка,
    проверяем возвращает ли метод remove() удаленное число,
    проверяем корректно ли работает выброс исключения метода remove()*/
        Integer a = 22;
        Integer b = 111;
        System.out.println(integerList.remove(a));
        System.out.println(integerList.remove(b));
        System.out.println(integerList.size());
        System.out.println(integerList);

    /*удаляем элемент из списка по индексу,
    проверяем возвращает ли метод remove() удаленное число
    проверяем корректно ли работает выброс исключения метода remove()*/
        System.out.println(integerList.remove(5));
        System.out.println(integerList.size());
        System.out.println(integerList);

        /*проверяем наличие элемента в списке*/
        Integer one = 1;
        System.out.println(integerList.size());
        System.out.println(integerList.contains(one));
        Integer two = 2;
        System.out.println(integerList.contains(two));
        Integer three = 3;
        System.out.println(integerList.contains(three));

        /*ищем элемент в списке*/
        System.out.println(integerList.indexOf(one));
        System.out.println(integerList.indexOf(three));

        /*ищем элемент в списке с конца*/
        System.out.println(integerList.lastIndexOf(two));
        System.out.println(integerList.lastIndexOf(three));

    /*получяем элемент из списка по индексу,
    проверяем корректно ли работает выброс исключения метода get()*/
        System.out.println(integerList.get(1));

    /*сравниваем текущий список с другим,
    проверяем корректно ли работает выброс исключения метода equals()*/
//      myIntegerList.equals(null);

        IntegerArrayListImpl integerList2 = new IntegerArrayListImpl();
        integerList2.add(10_000);
        System.out.println(integerList2.equals(integerList));

        integerList2.remove(0);
        integerList2.add(10);
        integerList2.add(1);
        integerList2.add(2);
        integerList2.add(3);
        System.out.println(integerList2);
        System.out.println(integerList2.equals(integerList));

        /*создаем новый массив из элементов списка*/
        System.out.println(Arrays.toString(integerList.toArray()));

        /*удаляем все элементы из списка*/
        integerList.clear();
        System.out.println(integerList.size());
        System.out.println(integerList);

        /*проверяем пустой ли список*/
        System.out.println(integerList.isEmpty());
        System.out.println(integerList2.isEmpty());
    }
}
