package ru.job4j.lsp.store;

import ru.job4j.lsp.store.foods.Food;
import java.util.List;

public class ControlQuality {

    private List<Store> stores = List.of(new Shop(), new Trash(), new Warehouse());

    public void distribute(Food food) {
        for (Store s : stores) {
            s.check(food);
        }
    }

    public List<Store> getStores() {
        return stores;
    }

}
