package ru.netology.taskScheduler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TasksTest {

    //Сдесь в поля ни чего не выношу,в тестах разные параметры.
    @Test
    public void testSimpleTaskBooleanFalse() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");


        boolean expected = false;
        boolean actual = simpleTask.matches("Завтра на работу");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSimpleTaskBooleanTrue() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");


        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить родителям");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicBooleanOneTask() {

        String[] subtasks = {"Яйца"};

        Epic epic = new Epic(55, subtasks);


        boolean expected = true;
        boolean actual = epic.matches("Яйца");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicBooleanTrueManyTasks() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Картофель", "Свекла", "Сахар", "Мёд", "Ягоды", "Капуста", "Крупа"};

        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Крупа");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicBooleanZeroTasks() {

        String[] subtasks = {};

        Epic epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Крупа");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicBooleanNoSuitableTask() {

        String[] subtasks = {"Молоко", "Яйца", "Хлеб", "Картофель", "Свекла", "Сахар", "Мёд", "Ягоды", "Капуста", "Крупа"};

        Epic epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Мясо");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingTopicTrue() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingProjectTrue() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = true;
        boolean actual = meeting.matches("Приложение НетоБанка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingNoSuitableTask() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = false;
        boolean actual = meeting.matches("Завтра выходной");

        Assertions.assertEquals(expected, actual);
    }
}
