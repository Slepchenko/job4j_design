package ru.job4j.cache;

import java.io.*;

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
                System.out.print("Введите ключ: ");
                String key = reader.readLine();
                dirFileCache.put(key, dirFileCache.load(key));
                System.out.println("Введите команду: 1. закрузить 2. получить 3. выход");
            }

            if (in.equals("2")) {
                System.out.print("выберите ключ: ");
                String key = reader.readLine();
                System.out.println(dirFileCache.get(key));
                System.out.println("Введите команду: 1. закрузить 2. получить 3. выход");
            }
        }
        System.out.println("Введите команду: 1. закрузить 2. получить 3. выход");
    }
}
