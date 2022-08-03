package ru.job4j.lsp.store;

import ru.job4j.lsp.store.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    private final List<Food> foods = new ArrayList<>();
    private final int minPercent = 25;
    private final int avgPercent = 75;
    private final int maxPercent = 100;

    @Override
    public boolean check(Food food) {
        double percentLifeExpired = getPercentLifeExpired(food);
        if (percentLifeExpired >= minPercent && percentLifeExpired < avgPercent) {
            foods.add(food);
            return true;
        }
        if (percentLifeExpired >= avgPercent && percentLifeExpired < maxPercent) {
            food.setPrice(food.getPrice() - food.getDiscount());
            foods.add(food);
            return true;
        }
        return false;
    }

    public List<Food> getFoods() {
        return new ArrayList<>(foods);
    }
}
