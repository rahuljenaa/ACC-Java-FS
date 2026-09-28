package com.accenture.ltt;

//Component Interface
interface Pizza {
 String makePizza();
}

//Concrete Component
class BasicPizza implements Pizza {
 public String makePizza() {
     return "Pizza Base";
 }
}

//Base Decorator
class PizzaDecorator implements Pizza {
 protected Pizza pizza;

 public PizzaDecorator(Pizza pizza) {
     this.pizza = pizza;
 }

 public String makePizza() {
     return pizza.makePizza();
 }
}

//Concrete Decorators adding behavior
class CheeseDecorator extends PizzaDecorator {
 public CheeseDecorator(Pizza pizza) { super(pizza); }
 public String makePizza() {
     return super.makePizza() + " + Cheese";
 }
}

class OliveDecorator extends PizzaDecorator {
 public OliveDecorator(Pizza pizza) { super(pizza); }
 public String makePizza() {
     return super.makePizza() + " + Olives";
 }
}

public class DecoratorPatternDemo {
 public static void main(String[] args) {
     Pizza pizza = new OliveDecorator(new CheeseDecorator(new BasicPizza()));
     System.out.println(pizza.makePizza()); 
     //  Pizza Base + Cheese + Olives
 }
}

