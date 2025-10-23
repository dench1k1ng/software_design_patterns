package coffeeshop.service;

import coffeeshop.core.Coffee;

public class InventoryService {
    public boolean checkInventory(Coffee order) {
        System.out.println("  [Inventory] Checking stock for: " + order.getDescription());
        if (order.getDescription().contains("Milk") && Math.random() < 0.1) {
            System.out.println("  [Inventory] ERROR: Low on milk. Order cancelled.");
            return false;
        }
        System.out.println("  [Inventory] Stock is sufficient.");
        return true;
    }

    public void deductStock() {
        System.out.println("  [Inventory] Required ingredients have been deducted from stock.");
    }
}
