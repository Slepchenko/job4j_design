package ru.job4j.lsp.parking;

import java.util.HashSet;
import java.util.Set;

public class GeneralParking implements Parking {

    private final Set<Car> passengerParking;
    private final Set<Car> truckParking;
    private int passengerSize;
    private int truckSize;

    public GeneralParking(int passengerSize, int truckSize) {
        this.passengerSize = passengerSize;
        this.truckSize = truckSize;
        this.passengerParking = new HashSet<>(passengerSize);
        this.truckParking = new HashSet<>(truckSize);
    }

    @Override
    public boolean add(Car car) {
        if (isContainCar(car)) {
            return false;
        }
        if (car.getSize() == 1 && passengerSize > 0 && passengerParking.size() < passengerSize) {
            passengerParking.add(car);
            passengerSize -= car.getSize();
            return true;
        }

        if (car.getSize() > 1 && car.getSize() <= truckSize) {
            truckParking.add(car);
            truckSize -= car.getSize();
            return true;
        } else if (car.getSize() <= passengerSize) {
            passengerParking.add(car);
            passengerSize -= car.getSize();
            return true;
        }
        return false;
    }

    private boolean isContainCar(Car car) {
        return passengerParking.contains(car) || truckParking.contains(car);
    }

    public Set<Car> getPassengerParking() {
        return new HashSet<>(passengerParking);
    }

    public Set<Car> getTruckParking() {
        return new HashSet<>(truckParking);
    }
}
