package by.du.todo.service;

import by.du.todo.exception.StopException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class InputService {

    private static final String DATE_TIME_PATTERN = "yy-MM-dd H-mm";
    private static final String DATE_PATTERN = "yy-MM-dd";

    private final Scanner scanner;
    private final TranslateService translateService;

    public LocalDateTime getLocalDateTime(String msg) {
        while (true) {
            try {
                System.out.printf(msg, DATE_TIME_PATTERN);
                final String text = scanner.nextLine();
                return LocalDateTime.parse(text, DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
            } catch (DateTimeParseException ex) {
                processingInvalidInput();
            }
        }
    }

    public String getLine(final String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

    public int nextInt() {
        while (true) {
            try {
                final int nextInt = scanner.nextInt();
                scanner.nextLine();
                return nextInt;
            } catch (InputMismatchException ex) {
                System.out.println();
                scanner.nextLine();
            }
        }
    }

    public int nextInt(final String msg) {
        System.out.println(msg);
        return nextInt();
    }

    public LocalDate getLocalDate(final String msg) {
        while (true) {
            try {
                System.out.printf(msg, DATE_PATTERN);
                final String text = scanner.nextLine();
                return LocalDate.parse(text, DateTimeFormatter.ofPattern(DATE_PATTERN));
            } catch (DateTimeParseException ex) {
                processingInvalidInput();
            }
        }
    }

    private void processingInvalidInput() {
        System.out.println(translateService.getString("invalidInput"));
        System.out.println(translateService.getString("repeat"));
        System.out.println(translateService.getString("stop"));
        try {
            final int nextInt = scanner.nextInt();
            scanner.nextLine();
            if (nextInt == 0) {
                throw new StopException();
            }
        } catch (InputMismatchException ignored) {
            System.out.println();
        }
    }
}
