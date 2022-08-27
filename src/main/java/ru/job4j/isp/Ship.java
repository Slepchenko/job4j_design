package ru.job4j.isp;

public interface Ship {
    void carryingCargo();

    void fishing();
}

/**
 * Нарушение в том, что класс CargoVessel это грузовое судно, оно будет использовать
 * только один метод carryingCargo(), а класс Fisher будет использовать только метод
 * fishing()
 */
class CargoVessel implements Ship {

    @Override
    public void carryingCargo() {
        System.out.println("Перевозка грузов");
    }

    @Override
    public void fishing() {

    }

    class Fisher implements Ship {

        @Override
        public void carryingCargo() {

        }

        @Override
        public void fishing() {
            System.out.println("Добыча рыбы");
        }
    }
}
