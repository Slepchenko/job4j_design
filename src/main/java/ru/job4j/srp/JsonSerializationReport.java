package ru.job4j.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

public class JsonSerializationReport implements Report {

    private Store store;

    public JsonSerializationReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Gson gsonBuilder = new GsonBuilder().create();
        return gsonBuilder.toJson(store.findBy(filter));
    }
}
