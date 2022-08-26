package ru.job4j.lsp.parking;

import java.util.HashSet;
import java.util.Set;

public class GeneralParking implements Parking {

    private final Set<Car> passengerParking;
    private final Set<Car> truckParking;
    private final int passengerParkingSize;
    private final int truckParkingSize;
    private int passengerSpaces = 0;
    private int truckSpaces = 0;

    public GeneralParking(int passengerSize, int truckSize) {
        this.passengerParkingSize = passengerSize;
        this.truckParkingSize = truckSize;
        this.passengerParking = new HashSet<>(passengerSize);
        this.truckParking = new HashSet<>(truckSize);
    }

    @Override
    public boolean add(Car car) {
        if (isContainCar(car)) {
            return false;
        }

        if (car.getSize() == PassengerCar.SIZE && passengerParkingSize > 0
                && passengerSpaces < passengerParkingSize) {
            passengerParking.add(car);
            passengerSpaces++;
            return true;
        }
        if (car.getSize() > PassengerCar.SIZE && truckParkingSize > 0
                && truckSpaces < truckParkingSize) {
            truckParking.add(car);
            truckSpaces++;
            return true;
        }
        if (car.getSize() > PassengerCar.SIZE && passengerParkingSize > 0
                && (passengerSpaces + car.getSize()) <= passengerParkingSize) {
            passengerParking.add(car);
            passengerSpaces += car.getSize();
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
