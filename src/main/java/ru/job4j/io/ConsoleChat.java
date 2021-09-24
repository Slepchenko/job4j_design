package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.function.Function;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final Map<String, Function<String, Boolean>> dispatch = new HashMap<>();
    private List<String> log = new ArrayList<>();
    private List<String> answers = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public Function<String, Boolean> outCom() {
        return out -> false;
    }

    public Function<String, Boolean> stopCom() {
        return str -> {
            boolean res = true;
            log.add(str);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = null;
            try {
                System.out.println("Введите ваш вопрос");
                s = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            while (!CONTINUE.equals(s)) {
                try {
                    System.out.println("Введите ваш вопрос");
                    s = reader.readLine();
                    if (OUT.equals(s)) {
                        res = false;
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                log.add(s);
                }
                log.add(s);
            return res;
        };
    }

    public Function<String, Boolean> continueCom() {
        return str -> {
            Random random = new Random();
            int index = random.nextInt(answers.size());
            log.add(str);
            log.add(answers.get(index));
            return true;
        };
    }

    public Function<String, Boolean> anotherCommand() {
        return str -> {
            Random random = new Random();
            String answer = answers.get(random.nextInt(answers.size()));
            System.out.println(answer);
            log.add(str);
            log.add(answer);
            return true;
        };
    }

    public void run() throws IOException {
        answers = readPhrases();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите вопрос");
        boolean isContinue = ask(reader.readLine());
        while (isContinue) {
            isContinue = ask(reader.readLine());
            System.out.println("Введите вопрос");
        }
        log.add("user: " + "закончить");
        saveLog(log);

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

    public ConsoleChat init() {
        this.load(ConsoleChat.OUT, this.outCom());
        this.load(ConsoleChat.STOP, this.stopCom());
        this.load(ConsoleChat.CONTINUE, this.continueCom());
        return this;
    }

    public void load(String command, Function<String, Boolean> action) {
        this.dispatch.put(command, action);
    }

    public boolean ask(String answ) {
        if (dispatch.get(answ) == null) {

            return anotherCommand().apply(answ);
        }
        return this.dispatch.get(answ).apply(answ);
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("./data/chat_log.txt", "./data/answer.txt");
        cc.init();
        cc.run();
    }
}
