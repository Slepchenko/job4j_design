package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

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
        String extension = args[1];
        if (extension == null) {
            throw new IllegalArgumentException(String.format("Not extension %s", file.getAbsoluteFile()));
        }
        Files.walkFileTree(Path.of(args[0]), new MyFileVisitor(args[1]));

    }

    public static class MyFileVisitor extends SimpleFileVisitor<Path> {

        private String extension;

        public MyFileVisitor(String extension) {
            this.extension = extension;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (file.toFile().getName().endsWith(extension)) {
                System.out.println(file.getFileName());
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
