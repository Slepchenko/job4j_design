package ru.job4j.lsp.parking;

import java.util.Objects;

public class Truck implements Car {

    private final int size;
    private final static int VALIDATE_SIZE = 1;

    public Truck(int size) throws Exception {
        if (size <= VALIDATE_SIZE) {
            throw new Exception();
        } else {
            this.size = size;
        }

    }

    @Override
    public int getSize() {
        return size;
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
        return size == truck.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }
}
