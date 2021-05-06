package ru.job4j.generics;

import java.util.Iterator;
import java.util.List;

public class SimpleArray<T> implements Iterable<T> {

    private int size = 0;
    private T[] array;

    public SimpleArray() {
    }

    public SimpleArray(T[] model) {
        array = model;
    }

    public void add(T model) {
        array[size++] = model;
    }

    public void set(int index, T model) {

    }

    public void remove(int index) {

    }

    public T get(int index) {
        return array[index];
    }

    public boolean checkIndex(int index, int size) {
        if (index < 0 || index > size) {
            return false;
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public static void main(String[] args) {

        int a = 5;
        SimpleArray<Integer> sa = new SimpleArray<>();
        System.out.println("created object: " + sa);
        sa.add(a);
        System.out.println("0 index is: " + sa.get(0));

    }
}
