package ru.job4j.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONStoreSerialization<T> implements StoreSerialization<T> {

    @Override
    public String serialization(T t) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(t);
    }
}
