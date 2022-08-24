package ru.job4j.lsp.parking;

import java.util.Objects;

public class PassengerCar implements Car {

    private static final int SIZE = 1;
    private String number;

    @Override
    public int getSize() {
        return SIZE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PassengerCar that = (PassengerCar) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
