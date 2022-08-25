package ru.job4j.lsp.parking;

import java.util.Objects;

public class Truck implements Car {

    private final int size;
    private String number;

    public Truck(int size, String number) {
        if (size <= PassengerCar.SIZE) {
            throw new IllegalArgumentException();
        } else {
            this.size = size;
        }
        this.number = number;
    }

    @Override
    public int getSize() {
        return size;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Truck truck = (Truck) o;
        return size == truck.size && Objects.equals(number, truck.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, number);
    }
}
