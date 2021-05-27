package ru.job4j.it;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.function.Predicate;

public class ListUtils {
    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();

        if (index == list.size() - 1) {
            while (i.hasNext()) {
                i.next();
            }
            i.add(value);
        }

        while (i.hasNext()) {
            if (i.nextIndex() > index) {
                i.add(value);
                break;
            }
            i.next();
        }

    }

    public static <T> T removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> i = list.listIterator();
        int index = 0;
        while (i.hasNext()) {
            T element = list.get(index);
            if (filter.test(element)) {
                i.next();
                i.remove();
                return element;
            }
            index++;
            i.next();
        }
        return null;
    }

    public static <T> T replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> i = list.listIterator();
        int index = 0;

        while (i.hasNext()) {
            T element = list.get(index);
            if (filter.test(element)) {
                i.next();
                i.set(value);
                return element;
            }
            index++;
            i.next();
        }
        return null;
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> i = list.listIterator();



        for (int j = 0; j < elements.size(); j++) {
            for (int k = 0; k < list.size(); k++) {
                if (elements.get(j).equals(list.get(k))) {
                    list.remove(k);
                    break;
                }
            }
        }


    }
}
