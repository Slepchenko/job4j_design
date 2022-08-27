package ru.job4j.isp;

public interface Fisher {
    void trawlFishing();
    void snurevodFishing();
    void highIceClass();
    void fishFactory();
}

/**
 * Интерфейс Fisher имеет более трех методов. Первые два парохода могут реализовать все
 * методы, третий не имеет завода для переработки рыбы. Лучне этот метод перенести в отдельный
 * интерфейс
 */

class TypeStercoder implements Fisher {
    @Override
    public void trawlFishing() {
        System.out.println("Использую трал");
    }

    @Override
    public void snurevodFishing() {
        System.out.println("Использую снюрревод");
    }

    @Override
    public void highIceClass() {
        System.out.println("Высокий ледовый класс");
    }

    @Override
    public void fishFactory() {
        System.out.println("Имею завод для переработки рыбы");
    }


    class TypeStr503 implements Fisher {
        @Override
        public void trawlFishing() {
            System.out.println("Использую трал");
        }

        @Override
        public void snurevodFishing() {
            System.out.println("Использую снюрревод");
        }

        @Override
        public void highIceClass() {
            System.out.println("Высокий ледовый класс");
        }

        @Override
        public void fishFactory() {
            System.out.println("Имею завод для переработки рыбы");
        }
    }

    class TypeSty420 implements Fisher {
        @Override
        public void trawlFishing() {
            System.out.println("Использую трал");
        }

        @Override
        public void snurevodFishing() {
            System.out.println("Использую снюрревод");
        }

        @Override
        public void highIceClass() {
            System.out.println("Высокий ледовый класс");
        }

        @Override
        public void fishFactory() {

        }
    }
}
