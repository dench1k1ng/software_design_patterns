package coffeeshop.facade;

import coffeeshop.core.Coffee;
import coffeeshop.service.CoffeeMaker;
import coffeeshop.service.InventoryService;
import coffeeshop.service.PaymentProcessor;

public class CoffeeOrderFacade {
    // Subsystem instances (Composition - Facade is composed of subsystems)
    private final InventoryService inventory;
    private final PaymentProcessor payment;
    private final CoffeeMaker maker;


    public CoffeeOrderFacade() {
        this.inventory = new InventoryService();
        this.payment = new PaymentProcessor();
        this.maker = new CoffeeMaker();
        System.out.println("--- Coffee Order System Initialized ---");
    }


    public boolean placeOrder(Coffee coffee) {
        float totalCost = coffee.getCost();
        String description = coffee.getDescription();

        System.out.println("\n[FACADE] Attempting to place order for: " + description + " (Total: $" + String.format("%.2f", totalCost) + ")");
        System.out.println("-------------------------------------------------------");

        // 1. Check if ingredients are available (Subsystem 1)
        if (!inventory.checkInventory(coffee)) {
            System.err.println("[FACADE] Order FAILED due to inventory issues.");
            return false;
        }

        // 2. Process the payment (Subsystem 2)
        if (!payment.processPayment(totalCost)) {
            System.err.println("[FACADE] Order FAILED due to payment issues.");
            return false;
        }

        // 3. Deduct stock (Subsystem 1)
        inventory.deductStock();

        // 4. Prepare the coffee (Subsystem 3)
        maker.prepareCoffee(coffee);

        System.out.println("-------------------------------------------------------");
        System.out.println("[FACADE] Order successfully fulfilled!");
        return true;
    }
}
