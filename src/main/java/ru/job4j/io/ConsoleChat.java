package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> log = new ArrayList<>();
        List<String> answers = readPhrases();
        Random random = new Random();
        int index;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String ask = reader.readLine();
            boolean isContinue = true;
            while (!ask.equals(OUT)) {
                index = random.nextInt(answers.size());
                if (ask.equals(STOP)) {
                    isContinue = false;
                }
                if (ask.equals(CONTINUE)) {
                    log.add("user: " + ask.toUpperCase());
                    isContinue = true;
                    ask = reader.readLine();
                    continue;
                }
                if (isContinue) {
                    String answer = answers.get(index);
                    log.add("user: " + ask);
                    log.add("ConsoleChat: " + answer);
                    System.out.println(answer);
                } else {
                    log.add("user: " + ask.toUpperCase());
                }
                ask = reader.readLine();
            }
            log.add("user: " + ask.toUpperCase());
            saveLog(log);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> readPhrases() {
        List<String> answers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers, Charset.forName("WINDOWS-1251")))) {
            while (reader.ready()) {
                answers.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answers;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1251")))) {
            for (String l : log) {
                writer.println(l);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("./data/chat_log.txt", "./data/answer.txt");
        cc.run();
    }
}
