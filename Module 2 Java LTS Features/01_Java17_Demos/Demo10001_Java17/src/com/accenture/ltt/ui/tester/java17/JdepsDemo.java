package com.accenture.ltt.ui.tester.java17;


import java.util.Date;
import java.util.ArrayList;
import java.util.*;

public class JdepsDemo {
    public static void main(String[] args) {
        Date now = new Date();
        ArrayList<String> names = new ArrayList<>();
        names.add("Java");
        names.add("Full Stack");

        System.out.println("Hello, time is: " + now);
        System.out.println("Learning: " + names);
    }
}