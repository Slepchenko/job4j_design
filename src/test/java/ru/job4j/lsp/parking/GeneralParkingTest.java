package ru.job4j.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@Ignore
public class GeneralParkingTest {

    @Test
    public void whenAddPassengerCarIntoPassengerParking() {
        Car passenger = new PassengerCar();
        Parking parking = new GeneralParking(5, 5);
        assertTrue(parking.add(passenger));
    }

    @Test
    public void whenAddPassengerCarIntoTruckParking() {
        Car passenger = new PassengerCar();
        Parking parking = new GeneralParking(5, 5);
        assertFalse(parking.add(passenger));
    }

    @Test
    public void whenAdd1TruckSize2IntoTruckParking() throws Exception {
        Car truck = new Truck(2);
        Parking parking = new GeneralParking(5, 5);
        assertTrue(parking.add(truck));
    }

    @Test
    public void whenAdd3TruckSize2IntoTruckParkingSize2() throws Exception {
        Car truck1 = new Truck(2);
        Car truck2 = new Truck(2);
        Car truck3 = new Truck(2);
        Parking parking = new GeneralParking(5, 2);
        parking.add(truck1);
        parking.add(truck2);
        assertFalse(parking.add(truck3));
    }

    @Test
    public void whenAdd1TruckSize2IntoPassengerParking() {
        Car passenger = new PassengerCar();
        Parking parking = new GeneralParking(5, 5);
        assertTrue(parking.add(passenger));
    }

    @Test (expected = Exception.class)
    public void whenAdd1PassengerIntoFullPassengerParking() throws Exception {
        Car passenger1 = new PassengerCar();
        Car truck = new Truck(2);
        Car passenger2 = new PassengerCar();
        Parking parking = new GeneralParking(3, 5);
        parking.add(passenger1);
        parking.add(truck);
        assertFalse(parking.add(passenger2));
    }

    @Test
    public void whenAdd1TruckSize2And1TruckSize3IntoPassengerParkingSize4() throws Exception {
        Car truck1 = new Truck(2);
        Car truck2 = new Truck(3);
        Parking parking = new GeneralParking(4, 5);
        parking.add(truck1);
        assertFalse(parking.add(truck2));
    }

    @Test
    public void whenAdd1PassengerIntoFullPassengerParkingSize5ByTrucks() throws Exception {
        Car truck1 = new Truck(2);
        Car truck2 = new Truck(3);
        Car passenger3 = new PassengerCar();
        Parking parking = new GeneralParking(5, 5);
        parking.add(truck1);
        parking.add(truck2);
        assertFalse(parking.add(passenger3));
    }

    @Test (expected = Exception.class)
    public void whenTruckSizeIs1() throws Exception {
        Car car1 = new Truck(1);
    }
}