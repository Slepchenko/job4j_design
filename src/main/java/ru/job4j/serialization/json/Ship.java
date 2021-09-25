package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Ship {
    private final boolean iceClass;
    private final int age;
    private final RoutingCert rc;
    private final String[] data;

    public Ship(boolean iceClass, int age, RoutingCert rc, String[] data) {
        this.iceClass = iceClass;
        this.age = age;
        this.rc = rc;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Ship{"
                + "iceClass=" + iceClass
                + ", age=" + age
                + ", rc=" + rc
                + ", data=" + Arrays.toString(data)
                + '}';
    }

    public static void main(String[] args) {
        String[] data = new String[]{"length 100, weight 39"};
        final Ship ship = new Ship(true, 26, new RoutingCert("Green Tundra"), data);

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(ship));
        System.out.println();
        final String shipJson =
                "{"
                    + "\"iceClass\":false,"
                    + "\"Age ship\":32,"
                    + "\"rc\":"
                        + "{"
                            + "\"name\":\"Even Given\""
//                            + "\"numIMO\":\"123456789\""
                        + "}"
                    + "\"data\":"
                        + "[\"Length 400m\", \"Weight 59m\"]"
                + "}";
        final Ship shipMod = gson.fromJson(shipJson, Ship.class);
        System.out.println(shipMod);
    }
}
