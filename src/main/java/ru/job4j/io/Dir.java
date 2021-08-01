package ru.job4j.io;


import ru.job4j.io.duplicates.DuplicatesVisitor;
import ru.job4j.io.duplicates.FileProperty;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.function.Predicate;

public class Dir extends SimpleFileVisitor<Path> {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
//        System.out.println(String.format("size : %s", file.getTotalSpace()));

        Files.walkFileTree(Path.of(args[0]), new MyFileVisitor(args[1]));

    }

    public static class MyFileVisitor extends SimpleFileVisitor<Path> {

        private String txt;

        public MyFileVisitor(String txt) {
            this.txt = txt;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            List<String> files = Files.readAllLines(file);
            for (String f : files) {
                if (f.endsWith(txt)) {
                    System.out.println(file.getFileName());
                }
            }
            return super.visitFile(file, attrs);
        }
    }
}
