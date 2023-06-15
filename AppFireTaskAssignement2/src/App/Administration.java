package App;

import java.util.Scanner;

public class Administration {
    public static TaskManager taskManager = new TaskManager();



    public static void mainMenu() {
        System.out.println("Welcome to the main menu");
        System.out.println(" (c)create task | (l)list of tasks | (e)edit task | (d)delete task | (t)export to csv file | (x)exit");
        Scanner sc = new Scanner(System.in);
        char choice = sc.next().charAt(0);

        switch (choice) {
            case 'c' -> {
                System.out.println("Enter task title");
                sc.nextLine();
                String title = sc.nextLine();
                System.out.println("Enter task description");
                String description = sc.nextLine();
                taskManager.createTask(title, description);
                System.out.println("Task created and stored successfully.");
                mainMenu();
            }
            case 'l' -> {
                taskManager.listTasks();
                mainMenu();
            }
            case 'e' -> {
                System.out.println("Enter the task index to update:");
                int updateIndex = Integer.parseInt(sc.next());
                System.out.println("Enter the updated task title");
                sc.nextLine();
                String updatedTitle = sc.nextLine();
                System.out.println("Enter the updated description");
                String updatedDescription = sc.nextLine();
                taskManager.editTask(updateIndex - 1, updatedTitle, updatedDescription);
                System.out.println("Task edited successfully.");
                mainMenu();
            }
            case 'd' -> {
                System.out.println("Enter the task index to delete:");
                sc.nextLine();
                int deleteIndex = Integer.parseInt(sc.nextLine());
                taskManager.deleteTask(deleteIndex - 1);
                System.out.println("Task deleted successfully.");
                mainMenu();
            }
            case 't' -> {
                System.out.println("Enter the file name with .csv extension\n where the task will be stored");
                sc.nextLine();
                String fileName = sc.nextLine();
                taskManager.exportTasksToCSV(fileName);
                mainMenu();
            }
            case 'x' -> System.exit(0);
        }
    }
}
