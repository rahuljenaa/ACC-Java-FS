package com.accenture.ltt.solution;

//Split the big interface into small specific behavior interfaces
interface EngineVehicle {
    void start();
    void stop();
}

interface Flyable {
    void fly();
}

//Airplane implements both
class Airplane implements EngineVehicle, Flyable {

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
        System.out.println("Airplane flying");
    }
}

//Car now implements only what it needs
class Car implements EngineVehicle {

    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }
}


public class ISPDemoSolution {

	public static void main(String[] args) {
		 EngineVehicle car = new Car();
	        car.start();
	        car.stop();

	        Flyable airplane = new Airplane();
	        airplane.fly();

	        EngineVehicle airplaneEngine = new Airplane();
	        airplaneEngine.start(); //  engine operations allowed
	}

}
