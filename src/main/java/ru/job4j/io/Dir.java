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
        for (File subfile : file.listFiles()) {
//            System.out.println("File's name: \"" + subfile.getName() + "\", length: " + subfile.length());
//            if (subfile.getName().endsWith(args[1])) {
//                System.out.println(subfile.getName());
//            }
            System.out.println();
            String a = subfile.getName();
            a = a.substring(a.length() - args[1].length());
            if (a.equals(args[1])) {
                System.out.println(subfile.getName());
            }
        }


    }
}
