package com.accenture.ltt;

public class TestShape {

    public static void main(String[] args) {

        // Create Circle object and call methods
        Circle circle = new Circle();
        circle.draw();
        circle.rotate();

        // Create Triangle object and call methods
        Triangle triangle = new Triangle();
        triangle.draw();
        triangle.calculatePerimeter();

        // Shape reference pointing to Circle object
        Shape shape1 = new Circle();
        shape1.draw();
        // shape1.rotate(); // Not accessible via Shape reference

        // Shape reference pointing to Triangle object
        Shape shape2 = new Triangle();
        shape2.draw();
        // shape2.calculatePerimeter(); // Not accessible via Shape reference
    }
}

