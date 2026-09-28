package com.todoapp.taskmanager;

import java.util.Scanner;

import com.todoapp.taskmanager.service.TaskService;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskService taskService = new TaskService();

        while (true) {
            System.out.println("\n--- To-Do List Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. Show Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Enter task description: ");
                    String desc = scanner.nextLine();
                    taskService.addTask(desc);
                    break;
                case "2":
                    taskService.showTasks();
                    break;
                case "3":
                    System.out.print("Enter task ID to mark as completed: ");
                    int completeId = Integer.parseInt(scanner.nextLine());
                    taskService.completeTask(completeId);
                    break;
                case "4":
                    System.out.print("Enter task ID to delete: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    taskService.deleteTask(deleteId);
                    break;
                case "5":
                    System.out.println("Exiting. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
