package homework.service.integer;

import homework.exception.ElementNotFoundException;
import homework.exception.IncorrectIndexException;

import java.util.Arrays;


public class IntegerArrayListImpl implements IntegerArrayList {
    private static final int CAPACITY = 10;
    private Integer[] array;
    private int size;
    public IntegerArrayListImpl() {
        this.array = new Integer[CAPACITY];
        this.size = 0;
    }
    public IntegerArrayListImpl (int initialCapacity) {
        this.array = new Integer[initialCapacity];
        this.size = 0;
    }
    private void checkItem (Integer item) {
        if(item == null)
            throw new NullPointerException("Ничего не передано");
    }

    private void checkIndex(Integer index) {
        if (index < 0 || index > size)
            throw new IncorrectIndexException("Индекс: " + index + ", Размер: " + size);
    }
    private void grow(int minCapacity) {
        int oldCapacity = array.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity / 2 * 3 ;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            array = Arrays.copyOf(array, newCapacity);
        }
    }
    private Integer[] trimToSize (Integer[] array) {
        Integer[] newArray = new Integer[size];
        System.arraycopy(array, 0, newArray, 0, size);
        array=newArray;
        return array;
    }
    private static void changeElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA]=arr[indexB];
        arr[indexB]=tmp;
    }
    private Integer[] sort (Integer[] array) {
        if (array.length < 2) {
            return array;
        }
        int middle = array.length/2;
        Integer[] left = new Integer[middle];
        Integer[] right = new Integer[array.length - middle];
        for (int i = 0; i < left.length; i++) {
            left[i] = array[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = array[middle+1];
        }
        sort(left);
        sort(right);
        merge(array, left, right);
        return array;
        }
        private void merge (Integer[] arr, Integer[] left, Integer[] right) {
        int mainP = 0;
        int leftP = 0;
        int rightP = 0;
            while (leftP < left.length && rightP < right.length) {
                if (left[leftP] <= right[rightP]) {
                    arr[mainP++] = left[leftP++];
                } else {
                    arr[mainP++]=right[rightP++];
                }
                }
            while (leftP < left.length) {
                arr[mainP++] = left[leftP++];
            }
            while (rightP < right.length) {
                arr[mainP++]=right[rightP++];
            }
            }
    public int binarySearch(Integer[] array, Integer item) {
        int start = 0;
        int end = size - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (item.equals(array[middle])) {
                return array[middle];
            }
            if (item < array[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }
    @Override
    public Integer add(Integer item) {
        checkItem(item);
        grow(size + 1);
        array[size++] = item;
        return item;    }

    @Override
    public Integer add(int index, Integer item) {
        checkIndex(index);
        checkItem(item);
        grow(size + 1);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        checkIndex(index);
        checkItem(item);
        Integer oldInteger = array[index];
        array[index] = item;
        return oldInteger;
    }

    @Override
    public Integer remove(Integer item) {
        checkItem(item);
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[size - 1] = null;
                size--;
                return item;
            }
        }
        throw new ElementNotFoundException(item + " не найден");
    }

    @Override
    public Integer remove(int index) {
        checkIndex(index);
        if (size == 1) {
            Integer oldInteger = array[0];
            array[0] = null;
            size--;
            return oldInteger;
        } else {
            Integer oldInteger = array[index - 1];
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size - 1] = null;
            size--;
            return oldInteger;
        }
    }

    @Override
    public boolean contains(Integer item) {
        checkItem(item);

        int currentInt = binarySearch(sort(trimToSize(array)), item);
        return currentInt == item;
    }

    @Override
    public int indexOf(Integer item) {
        checkItem(item);
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        checkItem(item);
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index >= 0 && index < size) {
            return array[index];
        }
        throw new IncorrectIndexException("Индекс: " + index + ", Размер: " + size);    }

    @Override
    public boolean equals(IntegerArrayList otherList) {
        if (otherList == null) {
            throw new NullPointerException("Ничего не передано");
        }
        if (otherList.size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!array[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] result = new Integer[size];
        System.arraycopy(array, 0, result, 0, size);
        return result;
    }
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }
}
