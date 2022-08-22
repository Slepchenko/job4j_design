package ru.job4j.lsp.parking;

public class PassengerParking implements Parking {
    @Override
    public boolean add(Car car) {
        return false;
    }
}
