package ru.job4j.cache;

import ru.job4j.io.PrintFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    List<Path> paths;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        return cache.get(key).get();
    }

    public void putFiles() throws IOException {
        Path start = Paths.get(cachingDir);
        paths = search(start, p -> p.toFile().getName().endsWith(".txt"));
        BufferedReader bufferedReader;
        for (Path p : paths) {
            bufferedReader = new BufferedReader(new FileReader(p.toString()));
            put(p.getFileName().toString(), bufferedReader.readLine());
            System.out.println(p.getFileName());
        }
        System.out.println();
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        PrintFiles searcher = new PrintFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
