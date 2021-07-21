package ru.job4j.question;

import java.util.*;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;

        Map<Integer, String> map = new HashMap<>();

        for (User p : previous) {
            map.put(p.getId(), p.getName());
        }

        int countDel = 0;
        for (User c : current) {
            String s = map.put(c.getId(), c.getName());
            if (s == null) {
                added++;
                countDel++;
            } else if (!s.equals(c.getName())) {
                changed++;
                map.remove(c.getId());
            } else if (s.equals(c.getName())) {
                map.remove(c.getId());
            }
        }
        return new Info(added, changed, map.size() - countDel);
    }
}
