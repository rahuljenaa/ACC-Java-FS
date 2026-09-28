package com.accenture.ltt.solution;

// Abstraction — Contract for all developer types
interface Developer {
 void develop();
}

// Low-level modules now depend on abstraction
class BackEndDeveloper implements Developer {
 public void develop() {
     System.out.println("Writing Java code...");
 }
}

class FrontEndDeveloper implements Developer {
 public void develop() {
     System.out.println("Writing JavaScript code...");
 }
}

//✅ High-level module depends on abstraction, not concrete classes
class Project {

 private Developer[] developers;

 public Project(Developer[] developers) {
     this.developers = developers;
 }

 public void buildProject() {
     for (Developer dev : developers) {
         dev.develop();
     }
 }
}

public class DIPDemoSolution {
 public static void main(String[] args) {

     Developer[] team = {
         new BackEndDeveloper(),
         new FrontEndDeveloper()
     };

     Project project = new Project(team);
     project.buildProject(); //  Works without knowing specific developer types
 }
}

