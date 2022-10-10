package ru.job4j.dip.store;

import ru.job4j.dip.store.foods.Food;

import java.util.ArrayList;
import java.util.List;


public class Trash implements Store {

    private final List<Food> foods = new ArrayList<>();
    private static final int PERCENT = 100;

    @Override
    public boolean check(Food food) {
        double percentLifeExpired = getPercentLifeExpired(food);
        if (percentLifeExpired >= PERCENT) {
            foods.add(food);
            return true;
        }
        return false;
    }

    public List<Food> getFoods() {
        return new ArrayList<>(foods);
    }
}
