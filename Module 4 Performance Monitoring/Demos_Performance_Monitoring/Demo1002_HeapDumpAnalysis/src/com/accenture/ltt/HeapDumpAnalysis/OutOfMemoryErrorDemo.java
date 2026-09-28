package com.accenture.ltt.HeapDumpAnalysis;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryErrorDemo {

	public static void main(String[] args) throws InterruptedException {
        List<int[]> list = new ArrayList<>();
        while (true) {
            list.add(new int[1_000_000]); // Allocate large arrays repeatedly
            Thread.sleep(2000);
        }
    }
}


