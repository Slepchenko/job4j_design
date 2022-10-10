package ru.job4j.dip.store.foods;

import java.util.Calendar;

public class Sausage extends Food {
    public Sausage(String name, Calendar expiryDate, Calendar createDate, double price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
