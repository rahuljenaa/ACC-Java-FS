package com.accenture.ltt;

//Demo 3: Tracing with Logger
//
//PURPOSE: Show multi-method flow and how INFO/WARNING appear differently.
//
//HOW TO VIEW:
//- Run normally -> see log levels in console.
//- Adjust logger level if needed.

import java.util.logging.Logger;
import java.util.logging.Level;

public class TracingWithLogger {
 private static final Logger LOG = Logger.getLogger(TracingWithLogger.class.getName());

 public static void main(String[] args) {
     // Optionally set a global level:
     LOG.setLevel(Level.ALL);

     LOG.info("=== Demo 3: Tracing With Logger START ===");
     int[] numbers = {2, -1, 3};

     int total = process(numbers);
     LOG.info("Final total = " + total);
     LOG.info("=== Demo 3: END ===");
 }

 static int process(int[] arr) {
     LOG.info("process() called with length=" + arr.length);
     int sum = 0;
     for (int i = 0; i < arr.length; i++) {
         LOG.fine("At index " + i + ", value=" + arr[i]); // FINE may be hidden if console default hides it
         sum = add(sum, arr[i]);
     }
     return sum;
 }

 static int add(int a, int b) {
     if (b < 0) {
         LOG.warning("add() received negative value: " + b); // WARNING stands out
     } else {
         LOG.info("add() adding " + b);
     }
     return a + b;
 }
}