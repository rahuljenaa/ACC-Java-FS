package com.accenture.ltt.problem;
//One Big Interface
interface Vehicle {

	void start();
    void stop();
    void fly();
}


// Airplane can fly - but okay here
class Airplane implements Vehicle {

    @Override
    public void start() {
        System.out.println("Airplane started");
    }

    @Override
    public void stop() {
        System.out.println("Airplane stopped");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Airplane flying!!");
    }
}

//Car forced to implement fly() unnecessarily
class Car implements Vehicle {

  @Override
  public void start() {
      System.out.println("Car started");
  }

  @Override
  public void stop() {
      System.out.println("Car stopped");
  }

  @Override
  public void fly() {
  	// Car cannot fly -> Wrong design!
      throw new UnsupportedOperationException("Car cannot fly!!");
  }
}

//This triggers exactly what ISP warns against:
//A class should not be forced to depend on methods it does not use

public class ISPDemoProblem {

	public static void main(String[] args) {
		Vehicle v = new Car();  // Valid substitution
        v.start();
        v.fly(); //  Runtime Exception -> Wrong interface design!

	}

}
