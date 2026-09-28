package com.accenture.ltt;

import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        // supplyAsync -> Runs in background thread without blocking main thread
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching data...");
            try { Thread.sleep(2000); } catch (Exception e) {}
            return 100; //  Task returns value
        })
        // thenApply -> Used for processing returned result
        .thenApply(data -> {
            System.out.println("Processing data…");
            return data * 2; // Transform result
        })
        // thenAccept -> Consumes the final value without returning further value
        .thenAccept(result -> System.out.println(" Final Result: " + result));

        // Main thread not blocked - continues executing
        System.out.println("Main thread is free to do other work!");

        try { Thread.sleep(3000); } catch (Exception e) {}
    }
}

