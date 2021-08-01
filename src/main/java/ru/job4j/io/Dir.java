package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

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
//        Path p = Paths.get(args[0]);
        Files.walkFileTree(Path.of("./"), new MyFileVisitor("class"));

    }

    public static class MyFileVisitor extends SimpleFileVisitor<Path> {

        private String txt;
//        private String p;

        public MyFileVisitor(String txt) {
            this.txt = txt;
//            this.txt = p;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            List<String> lines = Files.readAllLines(file);
//            for (String l: lines) {
//                if (l.endsWith(txt)) {
//                    System.out.println(file.getFileName());
//                }
//            }
            return FileVisitResult.CONTINUE;
        }
    }
}
