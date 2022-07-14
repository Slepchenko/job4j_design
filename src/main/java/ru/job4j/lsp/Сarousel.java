package ru.job4j.lsp;

class Carousel {

    int age;

    Carousel(int weight) {
        this.age = weight;
    }

    void run() {
        if (age < 17) {
            System.out.println("Возраст не подходит");
        }
    }


    static class Person {
        int age;

        Person(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }

    static class ChildrenCarousel extends Carousel {

        ChildrenCarousel(int age) {
            super(age);
        }

        /**
         * Тут изменили условие. Получается, что дети 16 лет пролетают со всеми каруселями
         * Если это подходящий как пример конечно
         */
        void run() {
            if (age > 15) {
                System.out.println("Возраст не подходит");
            }
        }
    }

    public static void main(String[] args) {
        Person person = new Person(16);
        Carousel carousel = new Carousel(person.getAge());
        carousel.run();

        Carousel carousel1 = new ChildrenCarousel(person.getAge());
        carousel1.run();
    }
}
