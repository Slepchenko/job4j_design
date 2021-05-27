package ru.job4j.it;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2,3);
        assertThat(Arrays.asList(0, 1, 2, 3), Is.is(input));
    }

    @Test
    public void whenAddAfterCentre() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 1, 9);
        assertThat(Arrays.asList(0, 1, 9, 2), Is.is(input));
    }

    @Test
    public void remove() {
        List<String> input = new ArrayList<>(Arrays.asList("Zero", "One", "Two"));
        String res = ListUtils.removeIf(input, (x) -> "Zero".equals(x));
        assertThat("Zero", Is.is(res));
        assertThat(Arrays.asList("One", "Two"), Is.is(input));
    }

    @Test
    public void replace() {
        List<String> input = new ArrayList<>(Arrays.asList("Zero", "One", "Two"));
        String res = ListUtils.replaceIf(input, (x) -> x.length() > 3, "Big string!");
        assertThat("Zero", Is.is(res));
        assertThat(Arrays.asList("Big string!", "One", "Two"), Is.is(input));
    }

    @Test
    public void removeAll() {

    }
}