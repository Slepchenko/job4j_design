package ru.job4j.lsp.parking;

import java.util.HashSet;
import java.util.Set;

public class GeneralParking implements Parking {

    private final Set<Car> passengerParking = new HashSet<>();
    private final Set<Car> truckParking = new HashSet<>();
    private final int passengerSize;
    private final int truckSize;

    public GeneralParking(int passengerSize, int truckSize) {
        this.passengerSize = passengerSize;
        this.truckSize = truckSize;
    }

    @Override
    public boolean add(Car car) {
        return false;
    }

    public Set<Car> getPassengerParking() {
        return new HashSet<>(passengerParking);
    }

    public Set<Car> getTruckParking() {
        return new HashSet<>(truckParking);
    }
}
