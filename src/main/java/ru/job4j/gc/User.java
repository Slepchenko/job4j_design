package ru.job4j.gc;

public class User {

    int id;

    String name;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
