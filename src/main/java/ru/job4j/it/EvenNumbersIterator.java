package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int index = point;
        if (isNum()) {
            point = index;
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {

        if (isNum()) {
            return data[point++];
        }

        throw new NoSuchElementException();
    }

    private boolean isNum() {
        for (int i = point; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                point = i;
                return true;
            }
            point++;
        }
        return false;
    }
}
