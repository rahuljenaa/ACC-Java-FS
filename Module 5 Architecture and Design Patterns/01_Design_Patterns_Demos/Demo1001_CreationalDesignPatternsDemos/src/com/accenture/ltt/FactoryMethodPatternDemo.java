package com.accenture.ltt;
//Helps in creating objects without exposing creation logic to the client
//Factory decides which object to create based on input
interface Payment {
    void pay(int amount);
}

class UpiPayment implements Payment {
    public void pay(int amount) {
        System.out.println("Paid via UPI: " + amount);
    }
}

class CardPayment implements Payment {
    public void pay(int amount) {
        System.out.println("Paid via Card: " + amount);
    }
}
//Factory class responsible for object creation logic
class PaymentFactory {
    public static Payment getPaymentMethod(String type) {
        if (type.equalsIgnoreCase("UPI")) return new UpiPayment();
        if (type.equalsIgnoreCase("CARD")) return new CardPayment();
        return null;
    }
}


public class FactoryMethodPatternDemo {
	// User doesn't know which class object is created internally
	public static void main(String[] args) {
		Payment payment = PaymentFactory.getPaymentMethod("CARD");
        payment.pay(500);
	}

}
