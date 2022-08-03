package ru.job4j.lsp.store;

import ru.job4j.lsp.store.foods.Food;

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
}
