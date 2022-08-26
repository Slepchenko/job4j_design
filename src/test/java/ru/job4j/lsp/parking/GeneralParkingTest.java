package ru.job4j.lsp.parking;

import org.junit.Test;

import static org.junit.Assert.*;

public class GeneralParkingTest {

    @Test
    public void whenAddPassengerCarIntoPassengerParking() {
        Car passenger = new PassengerCar("123");
        Parking parking = new GeneralParking(5, 5);
        assertTrue(parking.add(passenger));
    }

    @Test
    public void whenAddPassengerCarIntoTruckParking() {
        Car passenger = new PassengerCar("123");
        Parking parking = new GeneralParking(0, 5);
        assertFalse(parking.add(passenger));
    }

    @Test
    public void whenAdd1TruckSize2IntoTruckParking() {
        Car truck = new Truck(2, "123");
        Parking parking = new GeneralParking(5, 5);
        assertTrue(parking.add(truck));
    }

    @Test
    public void whenAdd3TruckSize2IntoTruckParkingSize2() {
        Car truck1 = new Truck(2, "123");
        Car truck2 = new Truck(2, "124");
        Car truck3 = new Truck(2, "125");
        Parking parking = new GeneralParking(0, 2);
        parking.add(truck1);
        parking.add(truck2);
        assertFalse(parking.add(truck3));
    }

    @Test
    public void whenAdd1PassengerIntoFullPassengerParking() {
        Car passenger1 = new PassengerCar("123");
        Car truck = new Truck(2, "124");
        Car passenger2 = new PassengerCar("125");
        Parking parking = new GeneralParking(3, 0);
        parking.add(passenger1);
        parking.add(truck);
        assertFalse(parking.add(passenger2));
    }

    @Test
    public void whenAdd1TruckSize2And1TruckSize3IntoPassengerParkingSize4() {
        Car truck1 = new Truck(2, "123");
        Car truck2 = new Truck(3, "124");
        Parking parking = new GeneralParking(4, 0);
        parking.add(truck1);
        assertFalse(parking.add(truck2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenTruckSizeIs1() {
        Car car1 = new Truck(1, "123");
    }
}