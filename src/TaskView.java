import java.util.List;
import java.util.Scanner;

public class TaskView {
    private TaskCollection taskCollection;
    private Scanner scanner;

    TaskView(TaskCollection collection) {
        this.scanner = new Scanner(System.in);
        this.taskCollection = collection;
    }

    private boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NullPointerException | NumberFormatException var3) {
            return false;
        }
    }

    private String prompt(String message) {
        System.out.println(message);
        return this.scanner.nextLine();
    }

    private int promptInt(String message) {
        String response = this.prompt(message);

        for(boolean isInt = this.isInteger(response); !isInt; isInt = this.isInteger(response)) {
            response = this.prompt(message);
        }

        return Integer.parseInt(response);
    }

    private void add() {
        String name = this.prompt("Enter the new task's name.");
        String description = this.prompt("Enter the new task's description.");
        int priority = this.promptInt("Enter the new task's priority");
        this.taskCollection.addTask(name, description, priority);
    }

    private void remove() {
        int index = this.promptInt("Enter the index of the task to remove.");
        this.taskCollection.removeTask(index);
    }

    private void update() {
        int index = this.promptInt("Enter the index of the task to update.");
        String newName = this.prompt("Enter the new name.");
        String newDescription = this.prompt("Enter the new Description");
        int newPriority = this.promptInt("Enter the new priority");
        this.taskCollection.updateTask(index, newName, newDescription, newPriority);
    }

    private void displayTasks(List<Task> tasks) {
        for(int i = 0; i < tasks.size(); ++i) {
            Task task = (Task)tasks.get(i);
            System.out.println("Task index: " + i + ", Name: " + task.getName() + ", Description: " + task.getDescription() + ", Priority: " + task.getPriority());
        }

    }

    private void list() {
        this.displayTasks(this.taskCollection.getTasks());
    }

    private void listByPriority() {
        int priority = this.promptInt("Enter a priority");
        this.displayTasks(this.taskCollection.getTasks(priority));
    }

    private void menu() {
        boolean endLoop = false;

        while(!endLoop) {
            System.out.println("Menu");
            System.out.println("1) Add a task.");
            System.out.println("2) Remove a task.");
            System.out.println("3) Update a task.");
            System.out.println("4) List all tasks.");
            System.out.println("5) List all tasks of a certain priority.");
            System.out.println("0) Exit");
            int userInput = this.promptInt("Choose an option.");
            switch (userInput) {
                case 0:
                    endLoop = true;
                    break;
                case 1:
                    this.add();
                    break;
                case 2:
                    this.remove();
                    break;
                case 3:
                    this.update();
                    break;
                case 4:
                    this.list();
                    break;
                case 5:
                    this.listByPriority();
            }
        }

    }

    public void run() {
        this.menu();
    }
}
