package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> res = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
               String[] lines = line.split(" ");
               if (Integer.parseInt(lines[lines.length - 2]) == 404) {
                   res.add(line);
               }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
            for (String s : log) {
                out.printf("%s%n", s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "result.txt");
        System.out.println(log);
    }
}
