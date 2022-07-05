package ru.job4j.srp;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarAdapterJson implements JsonSerializer<Calendar> {

    private static final ThreadLocal<DateFormat> DATE_FORMAT
            = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss X"));

    @Override
    public JsonElement serialize(Calendar calendar, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(DATE_FORMAT.get().format(calendar.getTime()));
    }
}
