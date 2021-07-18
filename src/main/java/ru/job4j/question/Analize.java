package ru.job4j.question;

import java.util.*;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;

        Map<Integer, String> general = new HashMap<>();
        Map<Integer, String> prev = new HashMap<>();
        Map<Integer, String> curr = new HashMap<>();

        for (User p : previous) {
            general.put(p.getId(), p.getName());
            prev.put(p.getId(), p.getName());
        }
        for (User c : current) {
            general.put(c.getId(), c.getName());
            curr.put(c.getId(), c.getName());
        }

        for (Map.Entry<Integer, String> g : general.entrySet()) {
            User u = new User(g.getKey(), g.getValue());
            if (prev.containsKey(u.getId()) && !curr.containsKey(u.getId())) {
                deleted++;
            } else if (!prev.containsKey(u.getId()) && curr.containsKey(u.getId())) {
                added++;
            } else if (prev.containsKey(u.getId()) && curr.containsKey(u.getId())) {
                if (!prev.get(u.getId()).equals(curr.get(u.getId()))) {
                    changed++;
                }
            }
        }
        return new Info(added, changed, deleted);
    }
}
