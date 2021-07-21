package io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {

        int[][] data = new int[9][9];
        String result = "";
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                result += ((i + 1) * (j + 1)) + " ";
            }
            result += "\n";
        }

        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(result.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
