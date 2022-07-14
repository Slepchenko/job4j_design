package ru.job4j.lsp;

public class Boat {
    int liveJacket = 15;
    int passengers;

    Boat(int passengers) {
        this.passengers = passengers;
    }

    boolean numberOfPassengers() {
        if (passengers < 10) {
            System.out.println("Лодка неполная, ждем пассажиров.");
            return false;
        }
/**
 * Проверка на то, чтобы каждому пассажуиру достался желет.
 */
        if (passengers > liveJacket) {
            System.out.println("Не хватает желетов. Ехать нельзя.");
            return false;
        }
        return true;
    }

    void run() {
        if (numberOfPassengers()) {
            System.out.println("Желетов хватает всем, нарушений нет! Поехали!!!");
        }
    }

    static class BadBoard extends Boat {

        BadBoard(int passengers) {
            super(passengers);
        }

        @Override
        boolean numberOfPassengers() {

            if (passengers < 10) {
                System.out.println("Мало людей, чем больше народу тем больше заработаем!"
                        + "Не будет хватать желетов? Да кому они нужны, я тыщу раз ходил к тем "
                        + "островам в плохую погоду");
                return false;
            }

            /**
             * Проигнорировали проверку на наличие желетов каждому пассажиру
             */
            return true;
        }
    }

    public static void main(String[] args) {
        Boat boat = new Boat(11);
        boat.run();


        /**
         * Нет проверки на наличие желетов каждому пассажиру, но желетов хватает всем
         */
        Boat badBoard = new BadBoard(40);
        badBoard.run();
    }

}
