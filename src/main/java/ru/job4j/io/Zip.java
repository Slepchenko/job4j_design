package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target, true)))) {
            for (File s : sources) {
                zip.putNextEntry(new ZipEntry(s.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(s))) {
//                    System.out.println(s.getAbsoluteFile());
                    zip.write(out.readAllBytes());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public static void main(String[] args) throws IOException {

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
        packFiles(filesPath(file, argsName.get("e")), new File(argsName.get("o")));
    }

    private static List<File> filesPath(File file, String path) throws IOException {
        List<File> files = new ArrayList<>();
        List<Path> paths = Search.search(Path.of(file.getAbsolutePath()), p -> !p.toFile().getName().endsWith(path));

        for (Path p : paths) {
            File f = new File(String.valueOf(p.getParent()) + "\\" + (p.getFileName()));
            files.add(f);
        }
        return files;
    }
}
