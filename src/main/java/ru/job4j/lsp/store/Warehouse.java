package ru.job4j.lsp.store;

import ru.job4j.lsp.store.foods.Food;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Warehouse implements Store {
    private final List<Food> foods = new ArrayList<>();

    @Override
    public void check(Food food) {
        Calendar now = Calendar.getInstance();
        long num1 = food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        long num2 = now.getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        long result = num2 * 100 / num1;

        if (result < 25) {
            foods.add(food);
        }
    }

    public List<Food> getList() {
        return foods;
    }
}
