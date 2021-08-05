package by.du.todo.controller;

import by.du.todo.service.InputService;
import by.du.todo.service.TranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@RequiredArgsConstructor
public class LanguageController {
    private final InputService inputService;
    private final TranslateService translateService;

    public void show() {
        while (true) {
            System.out.println(translateService.getString("selectLang"));
            System.out.println("1 - English");
            System.out.println("2 - Rus");
            System.out.println("0 - " + translateService.getString("exit"));
            System.out.println("------------------------");
            final int nextInt = inputService.nextInt();
            switch (nextInt) {
                case 1:
                    Locale.setDefault(Locale.US);
                    break;
                case 2:
                    Locale.setDefault(Locale.forLanguageTag("ru-RU"));
                    break;
                case 0:
                    return;
                default:
            }
        }
    }
}
