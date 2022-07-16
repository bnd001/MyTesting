package com.learn.MultiThreading;

// Java Program demonstrating Introduction to Java Executor
// Framework

// Importing concurrent classes from java.util package
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// Class 1
// Helper Class implementing runnable interface Callable
class Task implements Callable<String> {
    // Member variable of this class
    private String message;

    // Constructor of this class
    public Task(String message)
    {
        // This keyword refers to current instance itself
        this.message = message;
    }

    // Method of this Class
    public String call() throws Exception
    {
        return "Hiiii " + message + "!";
    }
}
// Class 2
// Main Class
// ExecutorExample
public class GFG {

    // Main driver method
    public static void main(String[] args)
    {

        // Creating an object of above class
        // in the main() method
        List<Task> listTask = new ArrayList<>();
        Task task1 = new Task("GeeksForGeeks1");
        Task task2 = new Task("GeeksForGeeks2");
        Task task3 = new Task("GeeksForGeeks3");
        listTask.add(task1);
        listTask.add(task2);
        listTask.add(task3);

        // Creating object of ExecutorService class and
        // Future object Class
        ExecutorService executorService
                = Executors.newFixedThreadPool(4);
        List<Future> listFuture = new ArrayList<>();
        for(Task t: listTask) {
            Future f = executorService.submit(t);
            listFuture.add(f);
        }
//        Future<String> result
//                = executorService.submit(task);

        // Try block to check for exceptions
        try {
            for (Future f : listFuture) {
                System.out.println(f.get());
            }
        }

        // Catch block to handle the exception
        catch (InterruptedException
                | ExecutionException e) {

            // Display message only
            System.out.println(
                    "Error occurred while executing the submitted task");

            // Print the line number where exception occurred
            e.printStackTrace();
        }

        // Cleaning resource and shutting down JVM by
        // saving JVM state using shutdown() method
        executorService.shutdown();
    }
}
