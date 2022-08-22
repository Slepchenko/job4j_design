package ru.job4j.lsp.parking;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void whenAddPassengerCarIntoPassengerParking() {
        Car car = new PassengerCar();
        Parking parking = new PassengerParking();
        assertTrue(parking.add(car));
    }

    @Test
    public void whenAddTrackIntoTrackParking() {
        Car car = new Truck();
        Parking parking = new TruckParking();
        assertTrue(parking.add(car));
    }

    @Test
    public void whenAddTruckIntoPassengerParkingWhereThereIsPlace() {
        Car car = new Truck();
        Parking parking = new PassengerParking();
        assertTrue(parking.add(car));
    }
}