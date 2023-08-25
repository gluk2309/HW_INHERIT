package ru.netology.taskScheduler;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TodosTest {

    // Общую логику вынес в поля,так и тесты понятнее и кода меньше.

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};

    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    Todos todos = new Todos();


    @Test
    public void shouldAddThreeTasksOfDifferentType() {

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchForTasksInMeeting() {


        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Выкатка 3й версии приложения");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchForTasksInEpic() {


        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchForTasksInSimpleTask() {


        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchNonExistentTask() {


        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};          // ожидаю пустой массив т.к такой задачи нет.
        Task[] actual = todos.search("Завтра выходной");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchNoTask() {


        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};          // ожидаю пустой массив т.к это не задача.
        Task[] actual = todos.search("Во вторник после обеда");
        Assertions.assertArrayEquals(expected, actual);
    }
}
