package com.accenture.ltt;

//Problem solved: Avoid multiple if-else for different behaviors.
// Provides flexibility to change the algorithm at runtime.
//Strategy interface

interface PaymentStrategy {
 void pay(int amount);
}

//Concrete strategies
class UpiPayment implements PaymentStrategy {
 public void pay(int amount) {
     System.out.println("Paid " + amount + " using UPI");
 }
}
//Concrete Strategy
class CardPayment implements PaymentStrategy {
 public void pay(int amount) {
     System.out.println("Paid " + amount + " using Card");
 }
}

//Context class that uses a strategy
class ShoppingCart {
 private PaymentStrategy strategy;

 // Set Strategy at runtime 
 public void setPaymentStrategy(PaymentStrategy strategy) {
     this.strategy = strategy;
 }

 public void checkout(int amount) {
     strategy.pay(amount); // Delegating behavior
 }
}

public class StrategyPatternDemo {
 public static void main(String[] args) {
     ShoppingCart cart = new ShoppingCart();

     cart.setPaymentStrategy(new UpiPayment());
     cart.checkout(500); // Paid using UPI

     cart.setPaymentStrategy(new CardPayment());
     cart.checkout(1000); // Paid using Card 
 }
}

//Benefit: Avoids multiple if-else conditions → flexible behavior change