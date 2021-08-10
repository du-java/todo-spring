package by.du.todo;

import by.du.todo.controller.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(final String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("by.du.todo");
        context.refresh();
        context.getBean(HomeController.class).show();
    }
}
