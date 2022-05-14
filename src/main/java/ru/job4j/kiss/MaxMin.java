package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {

    private <T> T findMinMax(List<T> value, Comparator<T> comparator, int k) {
        T num = value.get(0);
        for (T t : value) {
            if (comparator.compare(num, t) == k) {
                num = t;
            }
        }
        return num;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findMinMax(value, comparator, 1);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findMinMax(value, comparator, 0);
    }
}
