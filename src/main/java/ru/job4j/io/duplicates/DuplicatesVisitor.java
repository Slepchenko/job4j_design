package ru.job4j.io.duplicates;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, Integer> duplicates = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        File filePath = new File(file.toAbsolutePath().toString());
        FileProperty fp = new FileProperty(filePath.length(), file.getFileName().toString());
        Integer value = duplicates.get(fp);

        if (value != null) {
            duplicates.put(fp, value + 1);
            System.out.println(fp.getName() + " - " + (value + 1) + " шт.");
            return super.visitFile(file, attrs);
        }

        duplicates.put(fp, 0);
        return super.visitFile(file, attrs);
    }
}
