package ru.job4j.srp;

public class Srp {

    /**
     * 1-й класс делает кофе и продает напитки, нарушает принцип SRP, нужно
     * разделить их на два класса
     * 2-й класс зависит от реализации, я так понял, нужно делать отдельные
     * интерфейсы на каждый метод потом их реализовывать один или несколько
     * 3-й создает и инициализирует объект. Если я правильно понял, нужно
     * через конструктор инициализировать реалезацию makeCoffee
     */

    class CoffeeMachine1 {
        public void sellBeer() {
            System.out.println("Продает напитки");
        }

        public void makeCoffee() {
            System.out.println("Варит кофе");
        }
    }

    class MakeCoffee {
        public String cappuccino() {
           return "капучино";
        }

        public String americano() {
            return "американо";
        }

    }

    class CoffeeMachine3 {

        MakeCoffee makeCoffee = new MakeCoffee();

        public String make() {
            return makeCoffee.americano();
        }

        public int pay() {
            if (make().equals("американо")) {
                return 100;
            } else {
                return 150;
            }
        }
    }

}
