package ru.job4j.tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public interface Cinema {

    Ticket buy(Account account, int i, int i1, Calendar date);

    void add(Session3D session3D);

    List<Session> find(Predicate predicate);
}
