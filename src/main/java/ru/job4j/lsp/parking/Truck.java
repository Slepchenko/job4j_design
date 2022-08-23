package ru.job4j.lsp.parking;

public class Truck implements Car {

    private final int size;

    public Truck(int size) {
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }
}
