public class Task {
    private String name;
    private String description;
    private int priority;

    Task(String name, String description, int priority) {
        this.setName(name);
        this.setDescription(description);
        this.setPriority(priority);
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(int priority) {
        if (priority < 0) {
            this.priority = 0;
        } else if (priority > 5) {
            this.priority = 5;
        } else {
            this.priority = priority;
        }

    }
}

