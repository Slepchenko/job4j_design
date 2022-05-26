package ru.job4j.srp;

public class Srp {

    /**
     * 1-й класс делает кофе и продает напитки, нарушает принцип SRP, нужно
     * разделить их на два класса
     * 2. Паттерн синглтон
     * 3. метод print нарушает принцип srp
     */

    class CoffeeMachine1 {
        public void sellBeer() {
            System.out.println("Продает напитки");
        }

        public void makeCoffee() {
            System.out.println("Варит кофе");
        }
    }

    private static Srp instance = null;
    public static Srp getInstance() {
        if (instance == null) {
            instance = new Srp();
        }
        return instance;
    }


    class User {

        String name;

        public void print() {
            System.out.println(name);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
