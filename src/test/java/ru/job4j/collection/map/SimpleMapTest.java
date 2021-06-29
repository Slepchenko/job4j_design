package ru.job4j.collection.map;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.collection.SimpleArray;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void putTrue() {
        SimpleMap<Integer, String> sm = new SimpleMap<>();
        assertTrue(sm.put(1, "one"));
    }

    @Test
    public void putFalse() {
        SimpleMap<Integer, String> sm = new SimpleMap<>();
        sm.put(1, "one");
        assertFalse(sm.put(1, "one1"));
    }

    @Test
    public void getReturnValue() {
        SimpleMap<Integer, String> sm = new SimpleMap<>();
        sm.put(1, "one");
        assertThat(sm.get(1), Is.is("one"));
    }

    @Test
    public void getReturnNull() {
        SimpleMap<Integer, String> sm = new SimpleMap<>();
        sm.put(1, "one");
        assertNull(sm.get(2));
    }

    @Test
    public void removeTrue() {
        SimpleMap<Integer, String> sm = new SimpleMap<>();
        sm.put(1, "one");
        assertTrue(sm.remove(1));
    }

    @Test
    public void removeFalse() {
        SimpleMap<Integer, String> sm = new SimpleMap<>();
        sm.put(1, "one");
        assertFalse(sm.remove(2));
    }

    @Test
    public void iterator() {
        SimpleMap<Integer, String> sm = new SimpleMap<>();
        sm.put(1, "one");
        sm.put(2, "two");
        Iterator<Integer> it = sm.iterator();
        assertThat(it.next(), Is.is(1));
        assertThat(it.next(), Is.is(2));

    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleMap<Integer, String> sm = new SimpleMap<>();
        sm.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleMap<Integer, String> sm = new SimpleMap<>();
        sm.put(1, "one");
        Iterator<Integer> it = sm.iterator();
        sm.put(2, "two");
        it.next();
    }
}