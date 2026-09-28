package com.accenture.ltt.HeapDumpAnalysis;

	import java.util.ArrayList;
	import java.util.List;

	public class HeapDumpAnalysisDemo {
	    // A simple class to hold data
	    static class ObjectCreated {
	        private byte[] data = new byte[1024 * 1024];
	    }

	    public static void main(String[] args) throws InterruptedException {
	        List<ObjectCreated> list = new ArrayList<>();
	        for (int iter = 0; iter < 50; iter++) { 
	        	System.out.println("Starting Iteration "+iter);
	        
	        System.out.println("Starting memory allocation...");
	        for (int i = 0; i < 50; i++) { 
	            list.add(new ObjectCreated());
	            System.out.println("Allocated object #" + (i + 1));
	            Thread.sleep(500); // Slow down allocation for observation
	        }

	        System.out.println("Objects allocated. Keep the program running...");
	        Thread.sleep(6000); // Keep alive for VisualVM heap dump
	    }
	    }
	}