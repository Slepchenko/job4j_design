package ru.job4j.set;

import ru.job4j.collection.SimpleArray;

import java.util.HashSet;
import java.util.Iterator;

public class SimpleSet<T> implements Set<T> {

    private SimpleArray<T> set = new SimpleArray<>();

    HashSet<String> a = new HashSet<>();

    @Override
    public boolean add(T value) {
        Iterator<T> i = set.iterator();

        while (i.hasNext()) {
            T el = i.next();
            if (el == null && value == null) {
                return false;
            }
            if (el == null) {
                set.add(value);
                return true;
            }
            if (el.equals(value)) {
                return false;
            }
        }
        set.add(value);
        return true;
    }

    @Override
    public boolean contains(T value) {
        Iterator<T> i = set.iterator();
        while (i.hasNext()) {
            T el = i.next();
            if (el == null && value == null) {
                return true;
            }
            if (el == null) {
                continue;
            }

            if (el.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Iterator<T> i = set.iterator();

            @Override
            public boolean hasNext() {
                return i.hasNext();
            }

            @Override
            public T next() {
                return i.next();
            }
        };
    }
}
