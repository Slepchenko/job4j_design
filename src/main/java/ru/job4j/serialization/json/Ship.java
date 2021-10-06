package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public boolean isIceClass() {
        return iceClass;
    }

    public int getAge() {
        return age;
    }

    public String[] getData() {
        return data;
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
        JSONObject jsonRS = new JSONObject("{\"name]\":\"XVII съезв КПСС\"}");

        List<String> list = new ArrayList<>();
        list.add("Fishing");
        list.add("Trail");
        JSONArray jsonData = new JSONArray(list);

        final Ship ship = new Ship(false, 15, new RoutingCert("Grupper", 45647),
                new String[]{"fishing", "yarus"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("iceClass", ship.isIceClass());
        jsonObject.put("age", ship.getAge());
        jsonObject.put("rc", jsonRS);
        jsonObject.put("data", jsonData);

        System.out.println(jsonObject);
        System.out.println(new JSONObject(ship));
    }
}