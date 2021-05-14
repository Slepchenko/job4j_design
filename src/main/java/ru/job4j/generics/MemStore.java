package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        int index = findId(model.getId());
        if (index < 0) {
            mem.add(model);
        }
    }

    @Override
    public boolean replace(String id, T model) {
        int index = findId(id);
        if (index >= 0) {
            mem.set(index, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int index = findId(id);
        if (index >= 0) {
            mem.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        int index = findId(id);
        if (index >= 0) {
            return mem.get(index);
        }
        return null;
    }

    private int findId(String id) {
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
