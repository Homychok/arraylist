package homework.service.string;

import homework.exception.IncorrectIndexException;
import homework.exception.ElementNotFoundException;

import java.util.Arrays;

public class StringArrayListImpl implements StringArrayList {
    private static final int CAPACITY = 10;
    private String[] array;
    private int size;

    public StringArrayListImpl() {
        this.array = new String[CAPACITY];
        this.size = 0;
    }

    public StringArrayListImpl(int initCapacity) {
        this.array = new String[initCapacity];
        this.size = 0;
    }
    private void checkItem (String item) {
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
            int newCapacity = oldCapacity / 2 * 3 + 1;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    @Override
    public String add(String item) {
        checkItem(item);
        grow(size + 1);
        array[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkItem(item);
        checkIndex(index);
        grow(size + 1);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        checkItem(item);
        checkIndex(index);
        String oldString = array[index];
        array[index] = item;
        return oldString;
    }

    @Override
    public String remove(String item) {
        checkItem(item);
        for (int i = 0; i < size; i++) {
            if ((array[i].toLowerCase().trim())
                    .equals(item.toLowerCase().trim())) {
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
    public String remove(int index) {
        checkIndex(index);
        if (size == 1) {
            String oldString = array[0];
            array[0] = null;
            size--;
            return oldString;
        } else {
            String oldString = array[index-1];
            for (int i = index; i< size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size-1] =null;
            size--;
            return oldString;
        }
    }

    @Override
    public boolean contains(String item) {
checkItem(item);
        for (int i = 0; i < size; i++) {
            if ((array[i].toLowerCase().trim())
                    .equals(item.toLowerCase().trim())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        checkItem(item);
        for (int i = 0; i < size; i++) {
            if ((array[i].toLowerCase().trim())
                    .equals(item.toLowerCase().trim())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        checkItem(item);
        for (int i = size - 1; i >= 0; i--) {
            if ((array[i].toLowerCase().trim())
                    .equals(item.toLowerCase().trim())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= 0 && index < size) {
            return array[index];
        }
        throw new IncorrectIndexException("Индекс: " + index + ", Размер: " + size);
    }

    @Override
    public boolean equals(StringArrayList otherList) {
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
        if (size == 0)
            return true;
        else {
            return false;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }
    @Override
    public String toArray() {
        String[] newmassive = new String[size];
        System.arraycopy(array, 0, newmassive, 0, size);
        return Arrays.toString(newmassive);
    }
    public String toString() {
        return Arrays.toString((Arrays.copyOf(array, size)));
    }
    }

