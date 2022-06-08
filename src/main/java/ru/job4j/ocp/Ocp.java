package ru.job4j.ocp;

public class Ocp {

    public class CoffeeMachine1 {
        int coffee = 1;

        Make make;
        Cappuccino cappuccino;

        Cappuccino makeCoffee(int sugar) {
            make = new Make(coffee, sugar, cappuccino);

           return make.makeCoffee();
        }
    }



    public class Make {

        int sugar;
        Cappuccino cappuccino;

        public Make(int coffee, int sugar, Cappuccino cappuccino) {
            this.sugar = sugar;
            this.cappuccino = cappuccino;
        }

        public Cappuccino makeCoffee() {
            return new Cappuccino();
        }
    }

    public class Cappuccino {

    }

}
