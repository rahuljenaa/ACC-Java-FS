package com.accenture.ltt.solution;
//Encapsulation applied properly
class Circle {

	private double radius;
	
   //Validation ensures only valid values are set
    public Circle(double radius) {
        if(radius <= 0) {
            throw new IllegalArgumentException("Invalid radius!");
        }
        this.radius = radius;
    }
    //Behavior belongs inside the class
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
//Encapsulation applied
class Rectangle {

	private double length;
    private double width;

    //Constructor enforces valid data at object creation
    public Rectangle(double length, double width) {
        if(length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Invalid rectangle dimensions!");
        }
        this.length = length;
        this.width = width;
    }
    //Logic encapsulated -> no duplication
    public double calculateArea() {
        return length * width;
    }
}

public class OCPDemoSolution {

	public static void main(String[] args) {

		//Objects created with valid dimensions only
        Rectangle rectangle = new Rectangle(10, 5);
        Circle circle = new Circle(7);

        System.out.println("Rectangle Area: " + rectangle.calculateArea());
        System.out.println("Circle Area: " + circle.calculateArea());
    }
}

/*
 * Benefits:
//  Data protection - no unauthorized modification
//  Validation included - improves correctness
//  Logic stays inside class - easy maintenance
//  OOP principle “Encapsulation” fully achieved
 */
