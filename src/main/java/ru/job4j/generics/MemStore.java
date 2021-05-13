package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    private int index = -1;

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (findById(id) != null) {
            mem.set(index, model);
            index = -1;
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (findById(id) != null) {
            mem.remove(index);
            index = -1;
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                index = i;
                return mem.get(i);
            }
        }
        index = -1;
        return null;
    }
}
