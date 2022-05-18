package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

@Ignore
public class GeneratorTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNoKeyInPattern() {
        Generator generator = new TemplateGenerator();
        String template = "I am a ${surname}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Alexander");
        args.put("subject", "you");
        generator.produce(template, args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenExtraKey() {
        Generator generator = new TemplateGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Alexander");
        args.put("ExtraKey", "key");
        args.put("subject", "you");
        generator.produce(template, args);
    }
}