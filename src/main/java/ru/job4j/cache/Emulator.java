package ru.job4j.cache;

import java.io.*;
import java.nio.file.Path;

public class Emulator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите путь: ");
        DirFileCache dirFileCache = new DirFileCache(reader.readLine());
        System.out.println("Введите команду: 1. закрузить 2. получить 3. выход");
        String in = "-1";

        while (!in.equals("3")) {
            in = reader.readLine();
            if (in.equals("1")) {
                dirFileCache.putFiles();
                System.out.println("Введите команду: 1. закрузить 2. получить 3. выход");
            }

            if (in.equals("2")) {
                System.out.println("выберите ключ");
                for (Path p : dirFileCache.paths) {
                    System.out.println(p.getFileName());
                }
                String key = reader.readLine();
                System.out.println(dirFileCache.get(key));
                System.out.println("Введите команду: 1. закрузить 2. получить 3. выход");
            }
        }
        System.out.println("Введите команду: 1. закрузить 2. получить 3. выход");
    }
}
