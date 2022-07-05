package ru.job4j.srp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.StringJoiner;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() throws JAXBException {
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
    public void whenAccountingReport() throws JAXBException {
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
    public void whenHrReport() throws JAXBException {
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
    public void whenProgrammerReport() throws JAXBException {
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
    public void whenJSONSerialization() throws JAXBException {
        MemStore store = new MemStore();
        Calendar hired = Calendar.getInstance();
        hired.set(2022, Calendar.APRIL, 8, 0, 0, 0);
        Calendar fired = Calendar.getInstance();
        fired.set(2022, Calendar.AUGUST, 7, 0, 0, 0);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss X");
        String dateHired = formatter.format(hired.getTime());
        String dateFired = formatter.format(fired.getTime());
        Employee worker = new Employee("Ivan", hired, fired, 100);
        store.add(worker);
        Report jsonSerializationReport = new JsonSerializationReport(store);
        String employeeJsonTemplate =
                "{\"name\":\"%s\",\"hired\":\"%s\",\"fired\":\"%s\",\"salary\":%.1f}";
        StringBuilder expect = new StringBuilder()
                .append("{\"employees\":[")
                .append(String.format(Locale.US, employeeJsonTemplate,
                        worker.getName(), dateHired, dateFired, worker.getSalary()))
                .append("]}");

        assertThat(jsonSerializationReport.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenXMLSerialization() throws JAXBException {
        MemStore store = new MemStore();
        Calendar hired = Calendar.getInstance();
        hired.set(2022, Calendar.APRIL, 8, 0, 0, 0);
        Calendar fired = Calendar.getInstance();
        fired.set(2022, Calendar.AUGUST, 8, 0, 0, 0);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        String hiredDate = formatter.format(hired.getTime());
        String firedDate = formatter.format(fired.getTime());
        Employee worker = new Employee("Ivan", hired, fired, 100);
        store.add(worker);
        Report xml = new XmlSerializationReport(store);
        String result = xml.generate(em -> true);

        StringJoiner expected = new StringJoiner("\n");
        expected.add("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .add("<employees>")
                .add("    <employees>")
                .add(String.format("        <fired>%s</fired>", firedDate))
                .add(String.format("        <hired>%s</hired>", hiredDate))
                .add("        <name>Ivan</name>")
                .add("        <salary>100.0</salary>")
                .add("    </employees>")
                .add("</employees>\n");

        assertEquals(result, expected.toString());
    }
}