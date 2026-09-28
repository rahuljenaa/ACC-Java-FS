package com.todoapp.taskmanager.service;

import java.util.ArrayList;
import java.util.List;

import com.todoapp.taskmanager.model.Task;

public class TaskService {
    private List<Task> taskList = new ArrayList<>();
    private int nextId = 1;

    public void addTask(String description) {
        Task task = new Task(nextId++, description);
        taskList.add(task);
        System.out.println("Task added.");
    }

    public void showTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            taskList.forEach(System.out::println);
        }
    }

    public void completeTask(int id) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                task.setCompleted(true);
                System.out.println("Task marked as completed.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void deleteTask(int id) {
        taskList.removeIf(task -> task.getId() == id);
        System.out.println("Task deleted if it existed.");
    }
}
