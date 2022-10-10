package ru.job4j.dip.store;

import ru.job4j.dip.store.foods.Food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {
    private final List<Food> foods = new ArrayList<>();
    private static final int MIN_PERCENT = 25;
    private static final int AVG_PERCENT = 75;
    private static final int MAX_PERCENT = 100;

    @Override
    public boolean check(Food food) {
        double percentLifeExpired = getPercentLifeExpired(food);
        if (percentLifeExpired >= MIN_PERCENT && percentLifeExpired < AVG_PERCENT) {
            foods.add(food);
            return true;
        }
        if (percentLifeExpired >= AVG_PERCENT && percentLifeExpired < MAX_PERCENT) {
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
