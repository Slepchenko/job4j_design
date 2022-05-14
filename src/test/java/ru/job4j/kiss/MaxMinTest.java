package ru.job4j.kiss;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void whenIntMax34() {
        List<Integer> list = List.of(4, 2, 8, 2, 1, -5, 34, 0);
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return 1;
                }
                return 0;
            }
        };

        assertThat(maxMin.max(list, comparator), is(34));
    }

    @Test
    public void whenIntMinMinus5() {
        List<Integer> list = List.of(4, -5, 2, 8, 1, -5, 34, 0);
        MaxMin maxMin = new MaxMin();
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return 1;
                }
                return 0;
            }
        };

        assertThat(maxMin.min(list, comparator), is(-5));
    }

    @Test
    public void whenStringMaxD() {
        List<String> list = List.of("b", "a", "c", "d");
        MaxMin maxMin = new MaxMin();
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.compareTo(o2) <= 0) {
                    return 1;
                }
                return 0;
            }
        };

        assertThat(maxMin.max(list, comparator), is("d"));
    }

    @Test
    public void whenStringMinA() {
        List<String> list = List.of("b", "a", "c", "d");
        MaxMin maxMin = new MaxMin();
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.compareTo(o2) <= 0) {
                    return 1;
                }
                return 0;
            }
        };

        assertThat(maxMin.min(list, comparator), is("a"));
    }
}