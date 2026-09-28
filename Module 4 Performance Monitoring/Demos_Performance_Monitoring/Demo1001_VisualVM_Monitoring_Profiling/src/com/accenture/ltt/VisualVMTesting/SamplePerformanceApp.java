package com.accenture.ltt.VisualVMTesting;

public class SamplePerformanceApp {

    public static void main(String[] args) {

        System.out.println("SamplePerformanceApp started...");

        // Create multiple threads
        for (int i = 1; i <= 5; i++) {
            Thread worker = new Thread(new WorkerTask(i), "Worker-" + i);
            worker.setDaemon(false); // Ensure threads are visible in VisualVM
            worker.start();
        }

             try {
            while (true) {
                Thread.sleep(2000);
                System.out.println("Main thread alive...");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted.");
        }
    }

    // Worker thread that performs some CPU and memory load
    static class WorkerTask implements Runnable {
        private final int id;

        WorkerTask(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("Worker " + id + " started.");
            while (!Thread.currentThread().isInterrupted()) {
                heavyComputation();
                try {
                    Thread.sleep(100); // Reduce CPU intensity
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        private void heavyComputation() {
            double result = 0;
            for (int i = 0; i < 100000; i++) {
                result += Math.sqrt(i) * Math.random();
            }

            // Simulate temporary memory usage
            char[] data = new char[100000];
            if (result == -1) System.out.println(new String(data));
        }
    }
}