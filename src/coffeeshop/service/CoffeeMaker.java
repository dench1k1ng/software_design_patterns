package coffeeshop.service;

import coffeeshop.core.Coffee;

public class CoffeeMaker {
    public void prepareCoffee(Coffee order) {
        System.out.println("  [Preparation] Starting preparation of order...");
        System.out.println("  [Preparation] Brewing " + order.getDescription());
        // Simulate preparation time
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("  [Preparation] *** Your " + order.getDescription() + " is ready! ***");
    }
}
