package ru.job4j.srp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {


    private List<Employee> employees;

    public Employees() {
    }

    public Employees(List<Employee> employees) {
        this.employees = employees;
    }
}
