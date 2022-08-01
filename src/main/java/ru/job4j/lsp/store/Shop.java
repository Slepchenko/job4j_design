package ru.job4j.lsp.store;

import ru.job4j.lsp.store.foods.Food;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Shop implements Store {
    private List<Food> foods = new ArrayList<>();

    @Override
    public void check(Food food) {
        Calendar now = Calendar.getInstance();
        long num1 = food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        long num2 = now.getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        long result = num2 * 100 / num1;

        if (result >= 25 && result < 75) {
            foods.add(food);
        }
        if (result >= 75 && result < 100) {
            food.setPrice(food.getPrice() - food.getDiscount());
            foods.add(food);
        }
    }

    public List<Food> getList() {
        return foods;
    }
}
