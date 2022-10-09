package ru.job4j.dip;


/*
При создании класса Ship в конструктор мы указываем реализацию движетеля.
Необходимо создать интерфейс Mover (движетель) и передавать его в конструкор,
который будет инициализировать переменную. Переменная тоже должна быть типа
интерфеса Mover.

 */
public class Ship {
    Engine engine;
    public Ship(Engine engine) {
        this.engine = engine;
    }

    public class Engine {
        void move() {
            System.out.println("Использую двигатель");
        }
    }
}
