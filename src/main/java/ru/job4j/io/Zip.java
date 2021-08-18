package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    private static List<File> files = new ArrayList<>();
    public static void packFiles(List<File> sources, File target) {

    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        packSingleFile(
//                new File("./log.txt"),
//                new File("./logArchive.zip")
//        );
        ArgsName argsName = ArgsName.of(args);
        if (args.length < 3) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        File file = new File(argsName.get("d"));
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        if (args[1] == null) {
            throw new IllegalArgumentException(String.format("Not extension %s", file.getAbsoluteFile()));
        }

//        packFiles(source.toAbsolutePath(), target).forEach(System.out::println);
//        packFiles(
//                new File(files),
//                new File("./logArchive.zip")
//        );
    }
}
