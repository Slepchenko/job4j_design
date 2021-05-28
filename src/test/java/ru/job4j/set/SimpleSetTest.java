package ru.job4j.set;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenAddNullAndNotNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.add(1));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenNonElement() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertFalse(set.contains(2));
    }

    @Test
    public void iterator() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        Iterator<Integer> it = set.iterator();
        assertTrue(it.hasNext());
        assertThat(it.next(), Is.is(1));

    }

}