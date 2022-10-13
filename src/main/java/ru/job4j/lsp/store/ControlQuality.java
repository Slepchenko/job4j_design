package ru.job4j.lsp.store;

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
        for (Store s : stores) {
            addAll.addAll(s.getFoods());
        }
        clear();
        for (Food f : addAll) {
            distribute(f);
        }
    }

    private void clear() {
        for (Store s : stores) {
            s.clearFoods();
        }
    }
}
