package ru.job4j.srp;

public class Srp {

    /**
     * 1-й класс делает кофе и продает напитки, нарушает принцип SRP, нужно
     * разделить их на два класса
     * Паттерн синглтон нарушает srp. Проверяет наличие ранее созданных экземпляров
     *
     */

    class CoffeeMachine1 {
        public void sellBeer() {
            System.out.println("Продает напитки");
        }

        public void makeCoffee() {
            System.out.println("Варит кофе");
        }


    }



}
