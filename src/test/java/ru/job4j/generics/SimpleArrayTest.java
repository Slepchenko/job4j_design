package ru.job4j.generics;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {

    @Test
    public void addOneElement() {
        SimpleArray<Integer> test = new SimpleArray<>();
        int num = 5;
        test.add(num);
        assertThat(test.get(0), is(5));

    }

}