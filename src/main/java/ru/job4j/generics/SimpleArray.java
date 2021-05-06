package ru.job4j.generics;

import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {

    int index;
    int size;
    T[] array;

    public SimpleArray(T[] t) {
        size = t.length;
        array = t;
    }

    public void add(T model) {

    }

    public void set(int index, T model) {

    }

    public void remove(int index) {

    }

    public T get(int index) {
        return array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
