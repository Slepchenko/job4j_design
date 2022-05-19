package ru.job4j.template;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

@Ignore
public class GeneratorTest {

    @Test
    public void when() {
        Generator generator = new TemplateGenerator();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Alexander");
        args.put("subject", "you");
        assertThat(generator.produce(template, args),
                is("I am a Alexander, Who are you?"));
    }

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