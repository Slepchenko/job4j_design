package ru.job4j.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenAccountingReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        store.add(worker1);
        Report engine = new AccountingReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary() * AccountingReport.USD_RATE).append("$;")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));

    }

    @Test
    public void whenHrReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        store.add(worker1);
        Employee worker2 = new Employee("Vitia", now, now, 90);
        store.add(worker2);
        Employee worker3 = new Employee("Vitalya", now, now, 110);
        store.add(worker3);
        Report engine = new HrReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenProgrammerReport() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ProgrammerReport(store);
        StringBuilder expect = new StringBuilder()
                .append("<html lang=\"ru\">")
                .append("<head>")
                .append("<meta charset=\"UTF-8\">")
                .append("<title>Name; Hired; Fired; Salary;</title>")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator())
                .append("</head>")
                .append("<body>")
                .append("</body>")
                .append("</html>")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenJSONSerialization() {
        MemStore store = new MemStore();
        Calendar hired = Calendar.getInstance();
        hired.set(2022, 4, 8, 0, 0, 0);
        Calendar fired = Calendar.getInstance();
        fired.set(2022, 8, 8, 0, 0, 0);
        Employee worker = new Employee("Ivan", hired, fired, 100);
        store.add(worker);
        String expect = "[{\"name\":\"Ivan\",\"hired\":" +
                "{\"year\":2022,\"month\":4,\"dayOfMonth\":8," +
                "\"hourOfDay\":0,\"minute\":0,\"second\":0},\"fired\":" +
                "{\"year\":2022,\"month\":8,\"dayOfMonth\":8,\"hourOfDay\":0," +
                "\"minute\":0,\"second\":0},\"salary\":100.0}]";
        assertThat(store.serialization(new JSONStoreSerialization<>()), is(expect));
    }

    @Test
    public void whenXMLSerialization() {
        MemStore store = new MemStore();
        Calendar hired = Calendar.getInstance();
        hired.set(2022, 4, 8, 0, 0, 0);
        Calendar fired = Calendar.getInstance();
        fired.set(2022, 8, 8, 0, 0, 0);
        Employee worker = new Employee("Ivan", hired, fired, 100);
        store.add(worker);
        String expect = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<employees>\n" +
                "<employees>\n" +
                "<fired>2022-09-08T00:00:00.720+12:00</fired>\n" +
                "<hired>2022-05-08T00:00:00.684+12:00</hired>\n" +
                "<name>Ivan</name>\n" +
                "<salary>100.0</salary>\n" +
                "</employees>\n" +
                "</employees>\n";
        assertThat(store.serialization(new XMLStoreSerialization<>()), is(expect));
    }
}