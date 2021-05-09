package ru.job4j.generics;

import org.junit.Test;

import static org.junit.Assert.assertNull;
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
    public void setElementNumber99() {
        SimpleArray<Integer> test = new SimpleArray<>(5);
        int num1 = 5;
        int num2 = 2;
        test.add(num1);
        test.add(num2);
        test.set(1, 99);
        assertThat(test.get(1), is(99));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void WhenOverFlowException() {
        SimpleArray<String> test = new SimpleArray<>(2);
        test.add("one");
        test.add("two");
        test.add("three");
    }

    @Test
    public void whenRemoveElement() {
        SimpleArray<String> test = new SimpleArray<>(3);
        test.add("one");
        test.add("two");
        test.remove(0);
        assertThat(test.get(0), is("two"));
    }

    @Test
    public void whenRemoveLastElement() {
        SimpleArray<String> test = new SimpleArray<>(3);
        test.add("one");
        test.add("two");
        test.add("three");
        test.remove(0);
        assertThat(test.get(0), is("two"));
    }

    @Test
    public void whenOneElementArray() {
        SimpleArray<String> test = new SimpleArray<>(1);
        test.add("one");
        test.remove(0);
        assertNull(test.get(0), null);
    }

}