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
        String name = ArgsName.of(args).get("n");
        String searchType = ArgsName.of(args).get("t");
        String out = ArgsName.of(args).get("o");

        if ("name".equals(searchType)) {
            Search.search(start, x -> {
                String[] pair = x.toFile().getName().split("\\.");
                if (name.equals(pair[0])) {
                    writer(out, x.toFile() + System.lineSeparator());
                    return true;
                }
                return false;
            });
        }

        if ("mask".equals(searchType)) {
            String regName = name.replace("*", "[a-zA-Z0-9\\s_]+");
            regName = regName.replace("?", "[a-zA-Z0-9\\s_]");
            Pattern pattern = Pattern.compile(regName);
            Search.search(start, x -> {
                Matcher matcher = pattern.matcher(x.toFile().getName());
               if (matcher.find()) {
                   writer(out, x.toFile() + System.lineSeparator());
                   return true;
               }
               return false;
            });
        }
    }

    private static boolean predicate() {

        return false;
    }

    private static void writer(String out, String file) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(out, Charset.forName("WINDOWS-1251"), true))) {
            writer.write(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
