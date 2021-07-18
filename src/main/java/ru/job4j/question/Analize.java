package ru.job4j.question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted = 0;

//        Set<User> set = new HashSet<>(current);
        Map<Integer, String> map = new HashMap<>();
        for (User c : current) {
            map.put(c.getId(), c.getName());
        }
        for (User p : previous) {
            if (!map.containsKey(p.getId())) {
                deleted++;
                continue;
            }
            String str = map.put(p.getId(), p.getName());
            if (str != null && !str.equals(p.getName())) {
                changed++;
            } else if (str == null) {
                added++;
            }
        }

        return new Info(added, changed, deleted);

    }
}
