package com.accenture.ltt;

class Rectangle {
    public double length;
    public double width;
}

class Circle {
    public double radius;
}
// This violates Encapsulation — Object data is exposed directly.
public class OCPDemoProblem {
	
	    public static void main(String[] args) {
	        Rectangle r = new Rectangle();
	        r.length = -10;  //  Accepted but invalid
	        r.width = 5;

	        Circle c = new Circle();
	        c.radius = 7;

	        System.out.println("Rectangle Area: " + (r.length * r.width));
	        System.out.println("Circle Area: " + (3.14 * c.radius * c.radius));
	        //  Data is unprotected - anyone can change it
	        //  No validation logic -> Incorrect results possible
	        //  Violates Encapsulation principle of OOP
	        //  Area calculation logic scattered ->Hard to maintain
	}

}
//
//Better design solution = Apply Encapsulation + move logic inside class
