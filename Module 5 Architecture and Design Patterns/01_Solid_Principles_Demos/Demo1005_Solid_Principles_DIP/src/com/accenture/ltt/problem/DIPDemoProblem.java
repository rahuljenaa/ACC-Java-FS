package com.accenture.ltt.problem;

//Low-level module
class BackEndDeveloper {
 public void writeJava() {
     System.out.println("Writing Java code...");
 }
}

//Low-level module
class FrontEndDeveloper {
 public void writeJavaScript() {
     System.out.println("Writing JavaScript code...");
 }
}

// High-level module directly depends on low-level modules
// Tight coupling - cannot add new developer types without modifying this class
class Project {

 private BackEndDeveloper backEndDeveloper = new BackEndDeveloper();
 private FrontEndDeveloper frontEndDeveloper = new FrontEndDeveloper();

 public void buildProject() {
     backEndDeveloper.writeJava();       // Strong dependency
     frontEndDeveloper.writeJavaScript(); // Strong dependency
 }
}

public class DIPDemoProblem {
 public static void main(String[] args) {
     Project project = new Project();
     project.buildProject();
 }
}

