package ru.job4j.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

@Ignore
public class GeneralParkingTest {

    @Test
    public void whenAddPassengerCarIntoPassengerParking() {
        Car car = new PassengerCar();
        Parking parking = new GeneralParking(5, 5);
        assertTrue(parking.add(car, "Passenger"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenAddPassengerCarIntoTruckParkingThenException() {
        Car car = new PassengerCar();
        Parking parking = new GeneralParking(5, 5);
        parking.add(car, "Truck");
    }

    @Test
    public void whenAdd1TruckSize2IntoTruckParking() {
        Car car = new Truck(2);
        Parking parking = new GeneralParking(5, 5);
        assertTrue(parking.add(car, "Truck"));
    }

    @Test (expected = Exception.class)
    public void whenAdd3TruckSize2IntoTruckParkingSize2() {
        Car car1 = new Truck(2);
        Car car2 = new Truck(2);
        Car car3 = new Truck(2);
        Parking parking = new GeneralParking(5, 2);
        parking.add(car1, "Truck");
        parking.add(car2, "Truck");
        parking.add(car3, "Truck");
    }

    @Test
    public void whenAdd1TruckSize2IntoPassengerParking() {
        Car car = new PassengerCar();
        Parking parking = new GeneralParking(5, 5);
        assertTrue(parking.add(car, "Passenger"));
    }

    @Test (expected = Exception.class)
    public void whenAdd1PassengerIntoFullPassengerParking() {
        Car car1 = new PassengerCar();
        Car car2 = new Truck(2);
        Car car3 = new PassengerCar();
        Parking parking = new GeneralParking(3, 5);
        parking.add(car1, "Passenger");
        parking.add(car2, "Passenger");
        parking.add(car3, "Passenger");
    }

    @Test (expected = Exception.class)
    public void whenAdd1TruckSize2And1TruckSize3IntoPassengerParkingSize4ThenException() {
        Car car1 = new Truck(2);
        Car car2 = new Truck(3);
        Parking parking = new GeneralParking(4, 5);
        parking.add(car1, "Passenger");
        parking.add(car2, "Passenger");
    }

    @Test (expected = Exception.class)
    public void whenAdd1PassengerIntoFullPassengerParkingSize5ByTrucksThenException() {
        Car car1 = new Truck(2);
        Car car2 = new Truck(3);
        Car car3 = new PassengerCar();
        Parking parking = new GeneralParking(5, 5);
        parking.add(car1, "Passenger");
        parking.add(car2, "Passenger");
        parking.add(car3, "Passenger");
    }
}