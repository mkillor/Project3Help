import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskCollection {
    private List<Task> tasks = new LinkedList();

    TaskCollection() {
    }

    private Task createTask(String name, String description, int priority) {
        return new Task(name, description, priority);
    }

    public void addTask(String name, String description, int priority) {
        this.tasks.add(this.createTask(name, description, priority));
    }

    public void removeTask(int index) {
        if (this.tasks.size() > index) {
            this.tasks.remove(index);
        }

    }

    public void updateTask(int index, String name, String description, int priority) {
        this.tasks.set(index, this.createTask(name, description, priority));
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public List<Task> getTasks(int priorty) {
        List<Task> matchedTasks = new LinkedList();
        Iterator var3 = this.tasks.iterator();

        while(var3.hasNext()) {
            Task task = (Task)var3.next();
            if (task.getPriority() == priorty) {
                matchedTasks.add(task);
            }
        }

        return matchedTasks;
    }
}

