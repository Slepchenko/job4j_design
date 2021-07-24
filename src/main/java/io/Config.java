package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String[] pair;

            while (in.ready()) {
                String line = in.readLine();
                if (line.equals("") || line.charAt(0) == '#') {
                    continue;
                }
                pair = line.split("=");
                if (pair.length < 2) {
                    throw new IllegalArgumentException();
                }
                values.put(pair[0], pair[1]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        for (Map.Entry<String, String> k : values.entrySet()) {
            if (key.equals(k.getKey())) {
                return k.getValue();
            }
        }
        throw new UnsupportedOperationException("Don't impl this method yet!");
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {

    }
}
