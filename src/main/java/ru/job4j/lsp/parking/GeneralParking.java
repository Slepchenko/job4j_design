package ru.job4j.lsp.parking;

import java.util.HashSet;
import java.util.Set;

public class GeneralParking implements Parking {

    private Set<Car> passengerParking;
    private Set<Car> truckParking;

    public GeneralParking(int passengerSize, int truckSize) {
        this.passengerParking = new HashSet<>(passengerSize);
        this.truckParking = new HashSet<>(truckSize);
    }

    @Override
    public boolean add(Car car, String parking) {
        return false;
    }

    public Set<Car> getPassengerParking() {
        return passengerParking;
    }

    public Set<Car> getTruckParking() {
        return truckParking;
    }
}
