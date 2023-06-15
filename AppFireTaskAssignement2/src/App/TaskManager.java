package App;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskManager {

    private List<Task> taskList;


    public TaskManager() {
        this.taskList = new ArrayList<>();
    }

    public void createTask(String title, String description) {
        Task task = new Task(title, description);
        this.taskList.add(task);

    }

    public int getTaskCount() {
        return taskList.size();
    }

    public void listTasks() {

        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            System.out.println("Task #" + (i + 1) + ": " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println();

        }
    }

    public void setTaskList(List<Task> list) {
        this.taskList = list;
    }


    public void editTask(int index, String title, String description) {
        if (index >= 0 && index < this.taskList.size()) {
            Task task = this.taskList.get(index);
            task.setTitle(title);
            task.setDescription(description);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < this.taskList.size()) {
            this.taskList.remove(index);
        } else {
            System.out.println("Invalid task index.");
        }
    }


    public void exportTasksToCSV(String fileName) {
        try {
            File myFile = new File(fileName);
            BufferedWriter fw = new BufferedWriter(
                    new FileWriter(fileName));
            if (myFile.exists()) {
                for (Task task : this.taskList) {
                    String[] taskData = {task.getTitle(), task.getDescription()};
                    fw.write(Arrays.toString(taskData) + "\n");

                }
                fw.close();
                System.out.println("Tasks exported to CSV file successfully.");
            }


        } catch (Exception e) {
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
            e.printStackTrace();

        }

    }

    public Task getTask(int index) {
        if (index >= 0 && index < taskList.size()) {
            return taskList.get(index);
        } else {
            System.out.println("Invalid task index.");
            return null;
        }
    }
}
