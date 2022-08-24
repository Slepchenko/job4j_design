package ru.job4j.lsp.parking;

import java.util.HashSet;
import java.util.Set;

public class GeneralParking implements Parking {

    private final Set<Car> passengerParking;
    private final Set<Car> truckParking;
    private final int passengerSize;
    private final int truckSize;

    public GeneralParking(int passengerSize, int truckSize) {
        this.passengerSize = passengerSize;
        this.truckSize = truckSize;
        this.passengerParking = new HashSet<>(passengerSize);
        this.truckParking = new HashSet<>(truckSize);
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
