package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private int size = 0;
    private T[] array;

    public SimpleArray(int sizeArray) {
        array = (T[]) new Object[sizeArray];
    }

    public void add(T model) {
        array[size++] = model;
    }

    public void set(int index, T model) {
        if (!checkIndex(index, size)) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = model;
    }

    public void remove(int index) {
        if (!checkIndex(index, size)) {
            throw new IndexOutOfBoundsException();
        }
            System.arraycopy(array, index + 1, array, index, size - index - 1);
            array[size - 1] = null;
            size--;
    }

    public T get(int index) {
        if (!checkIndex(index, size)) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    private boolean checkIndex(int index, int size) {
        return index >= 0 && index < size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int point = 0;
            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[point++];
            }
        };
    }
}
