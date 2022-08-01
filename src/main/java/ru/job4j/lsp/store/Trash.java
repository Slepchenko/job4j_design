package ru.job4j.lsp.store;

import ru.job4j.lsp.store.foods.Food;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Trash implements Store {

    private List<Food> foods = new ArrayList<>();

    @Override
    public void check(Food food) {
        Calendar now = Calendar.getInstance();
        long num1 = food.getExpiryDate().getTimeInMillis();
        long num2 = now.getTimeInMillis();

        if (num1 < num2) {
            foods.add(food);
        }
    }

    public List<Food> getList() {
        return foods;
    }
}
