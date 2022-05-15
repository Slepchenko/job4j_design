package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {

    private <T> T findMinMax(List<T> value, BiPredicate<T, T> biPredicate) {
        T num = value.get(0);
        for (T t : value) {
            if (biPredicate.test(t, num)) {
                num = t;
            }
        }
        return num;
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findMinMax(value, (t, u) -> comparator.compare(t, u) <= 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findMinMax(value, (t, u) -> comparator.compare(t, u) > 0);
    }
}
