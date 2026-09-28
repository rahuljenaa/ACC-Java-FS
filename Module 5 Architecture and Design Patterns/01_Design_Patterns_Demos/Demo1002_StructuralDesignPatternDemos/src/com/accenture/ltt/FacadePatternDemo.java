package com.accenture.ltt;
class KitchenService {
    void prepareFood() {
        System.out.println("Food prepared!");
    }
}

class BillingService {
    void generateBill() {
        System.out.println("Bill generated!");
    }
}

class DeliveryService {
    void deliver() {
        System.out.println("Food delivered!");
    }
}

// Facade class that hides complexities
class FoodOrderFacade {
    private KitchenService kitchen = new KitchenService();
    private BillingService billing = new BillingService();
    private DeliveryService delivery = new DeliveryService();

    public void placeOrder() {
        kitchen.prepareFood();
        billing.generateBill();
        delivery.deliver();
        System.out.println("Order completed!");
    }
}

public class FacadePatternDemo {
    public static void main(String[] args) {
        new FoodOrderFacade().placeOrder();
    }
}
//Benefit: Easy API for the client → avoids interacting with multiple subsystems
