package homework.service;

import java.util.Arrays;
import java.util.Random;

public class CheckSortingTime {
    public static void main(String[] args) {

        Random rand = new Random();

        Integer[] array1 = new Integer[100_000];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = rand.nextInt();
        }

        Integer[] array2 = Arrays.copyOf(array1, array1.length);

        Integer[] array3 = Arrays.copyOf(array1, array1.length);

        Integer[] array4 = Arrays.copyOf(array1, array1.length);

        /*проверяем сколько времени занимает каждый вид сортировки*/
        /*пузырьковая сортировка*/
        long start1 = System.currentTimeMillis();
        sortBubble(array1);
        System.out.println(System.currentTimeMillis() - start1); //72_472

//        /*сортировка выборкой*/
//        long start2 = System.currentTimeMillis();
//        selectionSort(array2);
//        System.out.println(System.currentTimeMillis() - start2); //9_871
//
//        /*сортировка вставкой*/
//        long start3 = System.currentTimeMillis();
//        insertionSort(array3);
//        System.out.println(System.currentTimeMillis() - start3); //28_852
//
//        /*сортировка слиянием*/
//        long start4 = System.currentTimeMillis();
//        mergeSort(array4);
//        System.out.println(System.currentTimeMillis() - start4); //60
    }


    private static void changeElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    /*пузырьковая сортировка*/
    public static void sortBubble(Integer[] array) {
        //кол-во проходов по массиву, кол-во шагов = кол-во элементов-1
        for (int i = 0; i < array.length - 1; i++) {
            //проходим по всем элементам, кол-во шагов = кол-во элементов-1-i
            for (int j = 0; j < array.length - 1 - i; j++) {
                //сравнение текущего элемента со следующим
                if (array[j] > array[j+1]) {
                    /*меняем элементы местами*/
                    changeElements(array, j, j+1);
                    // добавляем элемент во временную переменную
//                    temp = array[j];
                    // приравниваем предыдущий элемент к следующему
//                    array[j] = array[j+1];
                    // бОльший элемент ставим на позиция справа
//                    array[j+1] = temp;
                }
            }
        }
    }

    /*сортировка выбором*/
    public static Integer[] selectionSort(Integer[] array){
        //кол-во проходов по массиву, кол-во шагов = кол-во элементов-1
        for (int i = 0; i < array.length - 1; i++) {
            //на каждом проходе -> индекс элемента из текущей ячейки(i) = мин в переменную minElementIndex
            int minElementIndex = i;
            //проходим по ячейкам, ограничение - i + 1 до последнего элемента включительно
            for (int j = i + 1; j < array.length; j++){
                //сравниваем все элементы с минимальным
                //ищем минимальный индекс
                if (array[j] < array[minElementIndex]){
                    //если тек элемент меньше, присваиваем его индекс в minElementIndex
                    minElementIndex = j;
                }
            }
            //в конце прохода внут цикла элемент по мин индексу обменивается местами с элементом по индексу i
            changeElements(array, minElementIndex, i);
//            int smallerNumber = array[minElementIndex];
//            array[minElementIndex] = array[i];
//            array[i] = smallerNumber;
        }
        return array;
    }

    /*сортировка вставкой*/
    public static void insertionSort(Integer[] array) {
        //проходим по всему элементам массива, кроме первого
        for (int i = 1; i < array.length; i++) {
            //запоминаем элемент, который находится по текущему индексу
            int currentElement = array[i];
            //объявляется переменная, которая будет идти в обратном направлении
            int j = i;
            //запускаем цикл, который смещается влево -> найден элемент меньше запомненного или пока не будет 0 элемент
            while (j > 0 && array[j-1] >= currentElement) {
                //смещаем все элементы, которые больше запомненного, на 1 ячейку вправо
                array[j] = array[j-1];
                j--;
            }
            //в освободившуюся позицию устанавливается значение из шага
            array[j] = currentElement;
        }
    }

    public static void sort(Integer[] array) {
        if (array.length < 2) {
            return;
        }
        int mid = array.length / 2;
        Integer[] left = new Integer[mid];
        Integer[] right = new Integer[array.length - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = array[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = array[mid + i];
        }

        sort(left);
        sort(right);

        merge(array, left, right);
    }

    public static void merge(Integer[] arr, Integer[] left, Integer[] right) {

        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
        while (leftP < left.length && rightP < right.length) {
            if (left[leftP] <= right[rightP]) {
                arr[mainP++] = left[leftP++];
            } else {
                arr[mainP++] = right[rightP++];
            }
        }
        while (leftP < left.length) {
            arr[mainP++] = left[leftP++];
        }
        while (rightP < right.length) {
            arr[mainP++] = right[rightP++];
        }
    }
}
