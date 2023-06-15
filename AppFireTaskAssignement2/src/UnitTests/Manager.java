package UnitTests;

import App.Task;
import App.TaskManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static App.Administration.taskManager;

class TaskManagerTest {

    @Test
    public void testCreateTask(){
        TaskManager taskManager = new TaskManager();
        String title = "Test task";
        String description = "Test description";
        taskManager.createTask(title, description);
        int actualTaskCount = taskManager.getTaskCount();

        Assertions.assertEquals(1, actualTaskCount);


    }

    @Test
    public void taskGetTaskCount(){
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task 1", "Description 1"));
        tasks.add(new Task("Task 2", "Description 2"));
        tasks.add(new Task("Task 3", "Description 3"));
        taskManager.setTaskList(tasks);


        // Step 2: Invoke the method being tested
        int actualTaskCount = taskManager.getTaskCount();

        // Step 3: Assert the expected behavior or outcome
        int expectedTaskCount = 3;
        Assertions.assertEquals(expectedTaskCount, actualTaskCount);
    }

    @Test
    public void listTasksTest(){

    }


    @Test
    public void deleteTasksTest(){
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task 1", "Description 1"));
        tasks.add(new Task("Task 2", "Description 2"));
        tasks.add(new Task("Task 3", "Description 3"));
        taskManager.setTaskList(tasks);

        int currentSize = tasks.size();
        int deleteIndex = 1;

        taskManager.deleteTask(deleteIndex);
        int newSize = tasks.size();
        Assertions.assertEquals(currentSize-1, newSize);
    }

    @Test
    public void editTasksTest(){
        taskManager.createTask("Task 1", "Description 1");
        taskManager.createTask("Task 2", "Description 2");
        taskManager.createTask("Task 3", "Description 3");


        taskManager.editTask(1,"Task1 is now Task41", "Description1 is now Description41");
        Task updatedTask = taskManager.getTask(1);
        Assertions.assertEquals("Task1 is now Task41", updatedTask.getTitle());
        Assertions.assertEquals("Description1 is now Description41", updatedTask.getDescription());


    }

    @Test
    public void ExportToCSVTest(){
        taskManager.createTask("Task 1", "Description 1");
        taskManager.createTask("Task 2", "Description 2");
        taskManager.createTask("Task 3", "Description 3");
        String fileName = "Test File";
        taskManager.exportTasksToCSV(fileName);
        File exportedFile = new File(fileName);
        Assertions.assertTrue(exportedFile.exists());
        if(exportedFile.exists()){
            try{
                exportedFile.delete();
            }catch(Exception e){
                System.out.println("Failed to delete the test file");
            }
        }

    }
}
