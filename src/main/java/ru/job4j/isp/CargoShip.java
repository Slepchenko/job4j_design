package ru.job4j.isp;

public interface CargoShip {
    void reefer();
    void bulk();
}

/**
 * Грузовое судно может использовать только один вид перевозки грузов. Нужно разбивать
 * интерфейс на два интерфейса со своим методом.
 */

class CarryingVessel implements CargoShip {
    @Override
    public void reefer() {
        System.out.println("Перевожу мороженную рыбопродукцию");
    }

    @Override
    public void bulk() {
        System.out.println("Перевожу уголь");
    }
}