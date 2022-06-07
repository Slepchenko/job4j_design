package ru.job4j.ocp;

public class Ocp {
    /**
     * Добавили в клас еще один метод, тем самым изменив его
     */
    public class CoffeeMachine1 {
        public void makeCoffee() {

        }
    }

    public class CoffeeMachine2 {
        public void makeCoffee() {

        }

        public void makeTea() {

        }
    }


    public class Make extends CoffeeMachine1 {

        @Override
        public void makeCoffee() {

        }
    }
}
