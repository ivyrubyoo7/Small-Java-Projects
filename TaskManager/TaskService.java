import java.util.*;

class TaskService {

    List<Task> tasks = new ArrayList<>();

    void addTask(String title, String priority) {
        if (title.isEmpty()) {
            throw new RuntimeException("Task title cannot be empty");
        }
        tasks.add(new Task(title, priority));
    }

    void markComplete(int index) {
        if (index < 0 || index >= tasks.size()) {
            throw new RuntimeException("Invalid task index");
        }
        tasks.get(index).completed = true;
    }

    List<Task> getTasks() {
        return tasks;
    }
}