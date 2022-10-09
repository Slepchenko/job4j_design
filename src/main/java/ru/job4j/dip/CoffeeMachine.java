package ru.job4j.dip;

/*
Нарушение в возвращаемых объектах.
 */
public class CoffeeMachine {

    public Coffee pay() {
        Coffee coffee = new Coffee();
        return coffee;
    }

    public class Coffee {

    }

}
