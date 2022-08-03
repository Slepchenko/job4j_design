package ru.job4j.lsp.store;

import ru.job4j.lsp.store.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {
    private final List<Food> foods = new ArrayList<>();
    private final int percent = 25;

    @Override
    public boolean check(Food food) {
        double percentLifeExpired = getPercentLifeExpired(food);
        if (percentLifeExpired < percent) {
            foods.add(food);
            return true;
        }
        return false;
    }

    public List<Food> getFoods() {
        return new ArrayList<>(foods);
    }
}
