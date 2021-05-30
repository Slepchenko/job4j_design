package ru.job4j.collection.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class TestMap {

    public static void main(String[] args) {
        Calendar date1 = new GregorianCalendar();

        User user1 = new User("Name", 1, date1);
        User user2 = new User("Name", 1, date1);

        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());

        for (User a : map.keySet()) {
            System.out.println(a);
        }
        System.out.println(map.size());

    }
}
