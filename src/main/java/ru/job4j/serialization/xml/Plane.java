package ru.job4j.serialization.xml;

import java.util.Arrays;

public class Plane {
    private final boolean warplane;
    private final int age;
    private final OnBoard onBoardNum;
    private final String[] data;

    public Plane(boolean warplane, int age, OnBoard onBoardNum, String[] data) {
        this.warplane = warplane;
        this.age = age;
        this.onBoardNum = onBoardNum;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Plane{"
                + "warplane=" + warplane
                + ", age=" + age
                + ", onBoardNum=" + onBoardNum
                + ", data=" + Arrays.toString(data)
                + '}';
    }

    public static void main(String[] args) {
        Plane plane1 = new Plane(false, 5, new OnBoard("VQ-BDU"), new String[]{"Passenger", "Russian"});
        System.out.println(plane1);
    }
}
