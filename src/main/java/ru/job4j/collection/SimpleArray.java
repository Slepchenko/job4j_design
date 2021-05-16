package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {

    private T[] elementData;
    private int size;
    private int modCount = 0;

    public SimpleArray() {
        elementData = (T[]) new Object[10];
        size = 0;
    }

    public SimpleArray(int size) {
        elementData = (T[]) new Object[size];
        this.size = 0;
    }

    public T get(int index) {
        if (!checkIndex(index, size)) {
            throw new IndexOutOfBoundsException();
        }
        return elementData[index];
    }

    public void add(T model) {
        if (size == elementData.length) {
            grow();
        }
        elementData[size] = model;
        size++;
        modCount++;
    }

    private boolean checkIndex(int index, int size) {
        return index >= 0 && index < size;
    }

    private void grow() {
        T[] newArray = (T[]) new Object[elementData.length + (elementData.length / 2)];
        System.arraycopy(elementData, 0, newArray, 0, elementData.length);
        elementData = newArray;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int point = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return elementData[point++];
            }
        };
    }
}

