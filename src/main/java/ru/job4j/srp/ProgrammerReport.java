package ru.job4j.srp;

import java.util.function.Predicate;

public class ProgrammerReport implements Report {

    private Store store;

    public ProgrammerReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html lang=\"ru\">")
                .append("<head>")
                .append("<meta charset=\"UTF-8\">")
                .append("<title>Name; Hired; Fired; Salary;</title>");
        text.append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        text.append("</head>")
                .append("<body>")
                .append("</body>")
                .append("</html>")
                .append(System.lineSeparator());
        return text.toString();
    }

}
