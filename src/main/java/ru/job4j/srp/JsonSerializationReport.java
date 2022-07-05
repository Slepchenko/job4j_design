package ru.job4j.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.function.Predicate;

public class JsonSerializationReport implements Report {

    private Store store;
    private GsonBuilder gsonBuilder;

    public JsonSerializationReport(Store store) {
        this.store = store;
        gsonBuilder = new GsonBuilder();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Employees employees = new Employees(store.findBy(filter));
        gsonBuilder.registerTypeAdapter(Calendar.class, new CalendarAdapterJson());
        gsonBuilder.registerTypeAdapter(GregorianCalendar.class, new CalendarAdapterJson());
        Gson gson = gsonBuilder.create();
        return gson.toJson(employees);
    }
}
