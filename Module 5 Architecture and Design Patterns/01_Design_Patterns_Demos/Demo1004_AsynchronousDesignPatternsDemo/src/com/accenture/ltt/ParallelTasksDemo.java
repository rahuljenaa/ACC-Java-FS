package com.accenture.ltt;

import java.util.concurrent.*;

public class ParallelTasksDemo {
    static CompletableFuture<String> fetchWeather() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(2000);
            return " Weather: 29°C";
        });
    }

    static CompletableFuture<String> fetchStock() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(3000);
            return " Stock: ₹ 2150";
        });
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        CompletableFuture<String> combined =
            fetchWeather().thenCombine(fetchStock(), (w, s) -> w + " | " + s);

        System.out.println("Main thread continues working...");
        System.out.println(" Result: " + combined.join());

        long end = System.currentTimeMillis();
        System.out.println(" Completed in " + (end - start) + "ms");
    }

    private static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (Exception e) {}
    }
}

