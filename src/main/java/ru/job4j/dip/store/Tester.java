package ru.job4j.dip.store;

import ru.job4j.dip.store.foods.Food;
import ru.job4j.dip.store.foods.Milk;

import java.util.Calendar;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(List.of(
                shop,
                warehouse,
                trash
        ));
        Calendar expiryDate = Calendar.getInstance();
        Calendar createDate = Calendar.getInstance();
        expiryDate.set(expiryDate.get(Calendar.YEAR) + 2,
                expiryDate.get(Calendar.MONTH),
                expiryDate.get(Calendar.DAY_OF_MONTH) + 5, 10, 0);
        createDate.set(createDate.get(Calendar.YEAR),
                createDate.get(Calendar.MONTH),
                createDate.get(Calendar.DAY_OF_MONTH) + 6, 10, 0);
        Food milk = new Milk("Milk", expiryDate, createDate, 60, 4);
        controlQuality.distribute(milk);
        System.out.println(shop.getFoods().size());
        System.out.println(warehouse.getFoods().size());
        System.out.println(trash.getFoods().size());
    }
}
