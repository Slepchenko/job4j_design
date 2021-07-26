package ru.job4j.io;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import ru.job4j.io.Analizy;

import java.io.*;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenTwoPeriods() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.printf("200 10:56:01" + System.lineSeparator());
            out.printf("500 10:57:01" + System.lineSeparator());
            out.printf("400 10:58:01" + System.lineSeparator());
            out.printf("200 10:59:01" + System.lineSeparator());
            out.printf("500 11:01:02" + System.lineSeparator());
            out.printf("200 11:02:02");
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(x -> rsl.append(x).append(System.lineSeparator()));
        }
        assertThat(rsl.toString(), is("10:57:01;10:59:01" + System.lineSeparator() +
                "11:01:02;11:02:02" + System.lineSeparator()));
    }
}