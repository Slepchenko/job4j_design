package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {

    /**
     * Проверяет параметр и выводит результат в зависимости от параметра.
     *
     * @param args параметры программы
     */
    public void run(String[] args) {
        Path path = Path.of(ArgsName.of(args).get("path"));
        if (ArgsName.of(args).get("out").equals("stdout")) {
            System.out.println(result(readFile(path), args));
        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(ArgsName.of(args).get("out")))) {
                writer.write(result(readFile(path), args));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Собирает конечный результат. Нужные колонки записываются в переменную String как результат
     *
     * @param lines Список строк из файла
     * @param args Параметры программы
     * @return рузультат
     */
    private String result(List<String> lines, String[] args) {
        StringBuilder result = new StringBuilder();
        List<String> specColumn = separatorSpecifiedColumn(ArgsName.of(args).get("filter"));
        String delimiter = ArgsName.of(args).get("delimiter");

        int[] points = new int[specColumn.size()];
        List<String> line = allColumn(lines.get(0));
        for (int i = 0; i < specColumn.size(); i++) {
            for (int j = 0; j < line.size(); j++) {
                if (specColumn.get(i).equals(line.get(j))) {
                    points[i] = j;
                }
            }
        }
        for (int i = 0; i < lines.size(); i++) {
            line = allColumn(lines.get(i));
            for (int j = 0; j < points.length; j++) {
                result.append(line.get(points[j]));
                if (j != points.length - 1) {
                    result.append(delimiter);
                }
            }
            if (i != lines.size() - 1) {
                result.append(System.lineSeparator());
            }
        }
        return result.toString();
    }

    /**
     * Разделяет все слова в переданной строке
     *
     * @param line Строка файла
     * @return список слов переданной строки
     */
    private List<String> allColumn(String line) {
        List<String> res = new ArrayList<>();
        Scanner scanner = new Scanner(new ByteArrayInputStream(line.getBytes())).useDelimiter(",");
        while (scanner.hasNext()) {
            res.add(scanner.next());
        }
        return res;
    }

    /**
     * Сепарирует слова - наименования колонки из строки входного параметра, который был получен
     * из параметра запуска с ключем filter
     *
     * @param specifiedColumn строка необходимых названий колонок взятая из аргументов программы
     * @return названия колонок
     */
    private List<String> separatorSpecifiedColumn(String specifiedColumn) {
        List<String> specColumn = new ArrayList<>();
        Scanner scanner = new Scanner(new ByteArrayInputStream(specifiedColumn.getBytes())).useDelimiter(",");
        while (scanner.hasNext()) {
            specColumn.add(scanner.next());
        }
        return specColumn;
    }

    /**
     * Разбивает файл на строки
     *
     * @param path Путь к файлу
     * @return Список строк из файла
     ********************************/
    private List<String> readFile(Path path) {
        List<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void main(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        if (argsName.invalid(4)) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        File file = Path.of(ArgsName.of(args).get("path")).toFile();
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (args[1] == null || args[2] == null || args[3] == null) {
            throw new IllegalArgumentException(String.format("Not extension %s", file.getAbsoluteFile()));
        }
        CSVReader csvReader = new CSVReader();
        csvReader.run(args);
    }
}