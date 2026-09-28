package com.accenture.ltt;
//Used to create complex objects step-by-step
//Avoids telescoping constructor (multiple parameter constructors)
class Pizza {
    private String base;
    private String cheese;
    private String toppings;

    // Private constructor - object built using Builder only
    private Pizza(Builder builder) {
        this.base = builder.base;
        this.cheese = builder.cheese;
        this.toppings = builder.toppings;
    }

    // Static inner Builder class
    static class Builder {
        private String base;
        private String cheese;
        private String toppings;

        // Methods return Builder itself for chaining
        Builder setBase(String base) { this.base = base; return this; }
        Builder setCheese(String cheese) { this.cheese = cheese; return this; }
        Builder setToppings(String toppings) { this.toppings = toppings; return this; }

        // Final step: build the actual Pizza object
        Pizza build() { return new Pizza(this); }
    }
}

public class BuilderPatternDemo {
    public static void main(String[] args) {
    	// Step-by-step construction
        Pizza pizza = new Pizza.Builder()
            .setBase("Thin Crust")
            .setCheese("Mozzarella")
            .setToppings("Mushrooms")
            .build();

        System.out.println("Pizza Ordered!");
    }
}
