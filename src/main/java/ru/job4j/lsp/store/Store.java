package ru.job4j.lsp.store;

import ru.job4j.lsp.store.foods.Food;

import java.util.Calendar;
import java.util.List;

public interface Store {
    boolean check(Food food);
    List<Food> getFoods();

    default double getPercentLifeExpired(Food food) {
        Calendar now = Calendar.getInstance();
        long num1 = food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        long num2 = now.getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        return (double) num2 * 100 / num1;
    }

}
