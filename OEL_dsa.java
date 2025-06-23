import java.util.*;

class Task {
    String taskName;  // Task description
    int priorityLevel; // Task priority level
    Date dueDate;  // Task deadline

    // Constructor to initialize a task with its name, priority, and deadline
    Task(String taskName, int priorityLevel, Date dueDate) {
        this.taskName = taskName;
        this.priorityLevel = priorityLevel;
        this.dueDate = dueDate;
    }

    // Overriding the toString() method to give a readable representation of a task
    @Override
    public String toString() {
        return "Task: " + taskName + ", Priority: " + priorityLevel + ", Due Date: " + dueDate;
    }

    // Inner class TaskManager to manage tasks
    static class TaskManager {
        private final Map<String, Task> taskMap;  // Map to store tasks by their name
        private final List<Task> taskList;  // List to maintain the order of tasks

        // Constructor initializing the task manager with empty map and list
        TaskManager() {
            taskMap = new HashMap<>();
            taskList = new ArrayList<>();
        }

        // Method to add a task
        public void createTask(Task task) {
            taskMap.put(task.taskName, task);  // Store task in the map
            taskList.add(task);  // Add task to the list
        }

        // Method to remove a task by its name
        public void deleteTask(String taskName) {
            Task task = taskMap.remove(taskName);  // Remove task from the map
            if (task != null) {
                taskList.remove(task);  // Remove task from the list
            }
        }

        // Method to update the priority and deadline of an existing task
        public void modifyTask(String taskName, int updatedPriority, Date updatedDueDate) {
            Task task = taskMap.get(taskName);  // Fetch the task from the map
            if (task != null) {
                task.priorityLevel = updatedPriority;  // Update the task's priority
                task.dueDate = updatedDueDate;  // Update the task's deadline
            }
        }

        // Method to sort the task list by priority
        public void sortTasksByPriority() {
            taskList.sort(Comparator.comparingInt(task -> task.priorityLevel));  // Sort tasks by priority level
        }

        // Method to print all tasks in the system
        public void displayAllTasks() {
            for (Task task : taskList) {
                System.out.println(task);  // Print each task's details
            }
        }
    }

    // Main method to demonstrate task management
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();  // Create an instance of TaskManager

        // Using Calendar to set deadlines for the tasks
        Calendar cal = Calendar.getInstance();
        cal.set(2024, Calendar.SEPTEMBER, 30);
        Date dueDate1 = cal.getTime();
        cal.set(2024, Calendar.OCTOBER, 15);
        Date dueDate2 = cal.getTime();
        cal.set(2024, Calendar.OCTOBER, 5);
        Date dueDate3 = cal.getTime();

        // Adding tasks to the task manager
        taskManager.createTask(new Task("Submit project report", 1, dueDate1));
        taskManager.createTask(new Task("Prepare slides for presentation", 2, dueDate2));
        taskManager.createTask(new Task("Code review for the project", 3, dueDate3));

        // Displaying all tasks before sorting
        System.out.println("Tasks currently in the system:");
        taskManager.displayAllTasks();

        // Sorting tasks by priority and displaying the result
        taskManager.sortTasksByPriority();
        System.out.println("\nTasks sorted by priority:");
        taskManager.displayAllTasks();

        // Updating a task's priority and deadline
        cal.set(2024, Calendar.OCTOBER, 25);
        Date newDueDate = cal.getTime();
        taskManager.modifyTask("Prepare slides for presentation", 1, newDueDate);

        // Displaying tasks after the update
        System.out.println("\nTasks after updating 'Prepare slides for presentation':");
        taskManager.displayAllTasks();

        // Removing a task from the system
        taskManager.deleteTask("Code review for the project");
        System.out.println("\nTasks after removing 'Code review for the project':");
        taskManager.displayAllTasks();
    }
}
