package ru.job4j.dip.store;

import ru.job4j.lsp.store.Store;
import ru.job4j.lsp.store.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void distribute(Food food) {
        for (Store s : stores) {
            s.check(food);
        }
    }

    public void resort() {
        List<Food> addAll = new ArrayList<>();

    }

    private void clear() {

    }
}
