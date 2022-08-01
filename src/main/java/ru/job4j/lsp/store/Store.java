package ru.job4j.lsp.store;

import ru.job4j.lsp.store.foods.Food;

import java.util.List;

public interface Store {
    void check(Food food);
    List<Food> getList();
}
