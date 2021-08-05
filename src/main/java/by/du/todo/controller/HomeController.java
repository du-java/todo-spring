package by.du.todo.controller;

import by.du.todo.service.InputService;
import by.du.todo.service.TranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HomeController implements Controller {

    private final InputService inputService;
    private final MeetingController meetingController;
    private final TaskController taskController;
    private final LanguageController languageController;
    private final TranslateService translateService;

    public void show() {
        System.out.println("ToDo List Application");
        while (true) {
            System.out.println("1 - Meetings");
            System.out.println("2 - Tasks");
            System.out.println("9 - " + translateService.getString("changeLang"));
            System.out.println("0 - " + translateService.getString("exit"));
            System.out.println("------------------------");
            final int nextInt = inputService.nextInt();
            switch (nextInt) {
                case 1:
                    meetingController.show();
                    break;
                case 2:
                    taskController.show();
                    break;
                case 9:
                    languageController.show();
                    break;
                case 0:
                    return;
                default:
            }
        }
    }
}
