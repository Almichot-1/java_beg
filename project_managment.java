import java.util.*;

// Abstract Task class
abstract class Task {
    protected String taskID;
    protected String taskName;
    protected String deadline;
    protected String priority;
    protected String status;

    public Task(String taskID, String taskName, String deadline, String priority) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.deadline = deadline;
        this.priority = priority;
        this.status = "Pending";
    }

    public abstract void completeTask();

    public void displayTaskInfo() {
        System.out.println("Task ID: " + taskID);
        System.out.println("Task Name: " + taskName);
        System.out.println("Deadline: " + deadline);
        System.out.println("Priority: " + priority);
        System.out.println("Status: " + status);
        System.out.println("------------------------");
    }
}

// Specific Task types
class BugFixTask extends Task {
    public BugFixTask(String taskID, String taskName, String deadline, String priority) {
        super(taskID, taskName, deadline, priority);
    }

    @Override
    public void completeTask() {
        this.status = "Completed";
        System.out.println("Bug Fix Task " + taskName + " marked as completed!");
    }
}

class FeatureDevelopmentTask extends Task {
    public FeatureDevelopmentTask(String taskID, String taskName, String deadline, String priority) {
        super(taskID, taskName, deadline, priority);
    }

    @Override
    public void completeTask() {
        this.status = "Completed";
        System.out.println("Feature Development Task " + taskName + " marked as completed!");
    }
}

// Project class
class Project {
    private String projectName;
    private String projectID;
    private List<Task> tasks;

    public Project(String projectName, String projectID) {
        this.projectName = projectName;
        this.projectID = projectID;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    public void displayProjectInfo() {
        System.out.println("Project Name: " + projectName);
        System.out.println("Project ID: " + projectID);
        System.out.println("Tasks:");
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (Task task : tasks) {
                task.displayTaskInfo();
            }
        }
    }

    public Task findTaskByID(String taskID) {
        for (Task task : tasks) {
            if (task.taskID.equals(taskID)) {
                return task;
            }
        }
        return null;
    }
}

// Main class
public class Main {
    private static List<Project> projects = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to CodeSphere Project Task Manager\n");

        boolean running = true;
        while (running) {
            System.out.println("1. Add New Project");
            System.out.println("2. Add Task to Project");
            System.out.println("3. Display All Projects");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addProject(scanner);
                case 2 -> addTaskToProject(scanner);
                case 3 -> displayProjects();
                case 4 -> markTaskCompleted(scanner);
                case 5 -> running = false;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addProject(Scanner scanner) {
        System.out.print("Enter Project Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Project ID: ");
        String id = scanner.nextLine();
        projects.add(new Project(name, id));
        System.out.println("Project added successfully!\n");
    }

    private static void addTaskToProject(Scanner scanner) {
        System.out.print("Enter Project ID: ");
        String projectID = scanner.nextLine();
        Project project = findProjectByID(projectID);

        if (project == null) {
            System.out.println("Project not found.\n");
            return;
        }

        System.out.println("Enter Task Type: 1 - Bug Fix, 2 - Feature Development");
        int taskType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Task Name: ");
        String taskName = scanner.nextLine();
        System.out.print("Enter Task ID: ");
        String taskID = scanner.nextLine();
        System.out.print("Enter Deadline (YYYY-MM-DD): ");
        String deadline = scanner.nextLine();
        System.out.print("Enter Priority (High/Medium/Low): ");
        String priority = scanner.nextLine();

        Task task = (taskType == 1) ? new BugFixTask(taskID, taskName, deadline, priority)
                                    : new FeatureDevelopmentTask(taskID, taskName, deadline, priority);

        project.addTask(task);
    }

    private static void displayProjects() {
        if (projects.isEmpty()) {
            System.out.println("No projects available.\n");
        } else {
            for (Project project : projects) {
                project.displayProjectInfo();
                System.out.println();
            }
        }
    }

    private static void markTaskCompleted(Scanner scanner) {
        System.out.print("Enter Project ID: ");
        String projectID = scanner.nextLine();
        Project project = findProjectByID(projectID);

        if (project == null) {
            System.out.println("Project not found.\n");
            return;
        }

        System.out.print("Enter Task ID: ");
        String taskID = scanner.nextLine();
        Task task = project.findTaskByID(taskID);

        if (task == null) {
            System.out.println("Task not found.\n");
        } else {
            task.completeTask();
        }
    }

    private static Project findProjectByID(String projectID) {
        for (Project project : projects) {
            if (project.projectID.equals(projectID)) {
                return project;
            }
        }
        return null;
    }
}
