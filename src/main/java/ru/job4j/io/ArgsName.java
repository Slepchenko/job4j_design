package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
       for (String a : args) {
           String[] pair = a.split("=");
           if (pair.length != 2) {
               throw new IllegalArgumentException();
           }
           values.put(pair[0].substring(1), pair[1]);
       }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public boolean invalid(int parameterQuantity) {
        return (parameterQuantity != values.size());
    }
}
