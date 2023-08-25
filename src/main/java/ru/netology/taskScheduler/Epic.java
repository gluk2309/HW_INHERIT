package ru.netology.taskScheduler;

public class Epic extends Task {

    private String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (String subtask : subtasks) {
            if (subtask.matches(query)) {
                return true;
            }
        }
        return false;

    }


    public String[] getSubtasks() {
        return subtasks;
    }
}
