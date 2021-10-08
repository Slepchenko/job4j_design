package ru.job4j.search;

import ru.job4j.io.ArgsName;
import ru.job4j.io.Search;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilesSearcher {

    public static void main(String[] args) throws IOException {
        Path start = Paths.get(String.valueOf(validate(args)));
        searcher(start, args);
    }

    private static File validate(String[] args) {
        if (args.length < 4) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        File file = new File(ArgsName.of(args).get("d"));
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        if (args[1] == null) {
            throw new IllegalArgumentException(String.format("Not extension %s", file.getAbsoluteFile()));
        }
        return file;
    }

    private static void searcher(Path start, String[] args) throws IOException {
        Map<String, String> values = new HashMap<>();
        values.put("n", ArgsName.of(args).get("n"));
        values.put("t", ArgsName.of(args).get("t"));
        values.put("o", ArgsName.of(args).get("o"));
        values.put("d", ArgsName.of(args).get("d"));

        Search.search(start, searchCondition(values));
    }

    private static Predicate<Path> searchCondition(Map<String, String> values) {
        Predicate<Path> result = null;
        String t = values.get("t");
        String n = values.get("n");
        if (t.equals("mask")) {
            String regName = t.replace("*", "[a-zA-Z0-9\\s_]+");
            regName = regName.replace("?", "[a-zA-Z0-9\\s_]");
            Pattern pattern = Pattern.compile(regName);
            result = path -> {
                Matcher matcher = pattern.matcher(path.toFile().getName());
                if (matcher.find()) {
                    writer(values.get("o"), path.toFile() + System.lineSeparator());
                    return true;
                }
                return false;
            };
        } else if (t.equals("name")) {
            String[] str = t.split("\\.");
            result = path -> {
                if (n.equals(str[0])) {
                    writer(values.get("o"), path.toFile() + System.lineSeparator());
                    return true;
                }
                return false;
            };
        }
        return result;
    }

    private static void writer(String out, String file) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(out, Charset.forName("WINDOWS-1251"), true))) {
            writer.write(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
