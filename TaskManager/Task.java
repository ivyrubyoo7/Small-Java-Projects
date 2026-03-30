class Task {
    String title;
    String priority;
    boolean completed;

    Task(String title, String priority) {
        this.title = title;
        this.priority = priority;
        this.completed = false;
    }

    @Override
    public String toString() {
        return title + " [" + priority + "] - " + (completed ? "Done" : "Pending");
    }
}