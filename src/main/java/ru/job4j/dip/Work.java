package ru.job4j.dip;

/*
Тут идет зависимость от реализации Work. Необходимо использовать интерфейс с методом
working который будет расширять класс Employee
 */
public class Work {
    public void working() {
        System.out.println("working");
    }

    public class Employee {
        public void doWork(Work work) {
            work.working();
        }
    }
}


