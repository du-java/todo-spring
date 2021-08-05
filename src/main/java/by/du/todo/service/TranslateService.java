package by.du.todo.service;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

@Component
public class TranslateService {
    public String getString(String key) {
        final ResourceBundle bundle = ResourceBundle.getBundle("todo");
        return new String(bundle.getString(key).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }
}
