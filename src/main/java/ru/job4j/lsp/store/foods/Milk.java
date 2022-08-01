package ru.job4j.lsp.store.foods;

import java.util.Calendar;

public class Milk extends Food {

    public Milk(String name, Calendar expiryDate, Calendar createDate, double price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
