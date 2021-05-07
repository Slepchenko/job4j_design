package ru.job4j.generics;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {

    @Test
    public void addOneElement() {
        SimpleArray<Integer> test = new SimpleArray<>(5);
        int num = 5;
        test.add(num);
        assertThat(test.get(0), is(5));
        SimpleArray<String> test2 = new SimpleArray<>(5);
        String str = "text";
        test2.add(str);
        assertThat(test2.get(0), is("text"));
    }

    @Test
    public void addTwoElements() {
        SimpleArray<Integer> test = new SimpleArray<>(5);
        int num1 = 5;
        int num2 = 2;
        test.add(num1);
        test.add(num2);
        assertThat(test.get(0), is(5));
        assertThat(test.get(1), is(2));
    }

    @Test
    public void setElementNumber2() {
        SimpleArray<Integer> test = new SimpleArray<>(5);
        int num1 = 5;
        int num2 = 2;
        int num3 = 10;
        test.add(num1);
        test.add(num2);
        test.add(num3);
        assertThat(test.set(1, 99), is(99));
    }
}