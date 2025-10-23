package coffeeshop.app;

import coffeeshop.core.Coffee;
import coffeeshop.core.SimpleCoffee;
import coffeeshop.core.customization.MilkDecorator;
import coffeeshop.core.customization.SyrupDecorator;
import coffeeshop.facade.CoffeeOrderFacade;

public class Main {
    public static void main(String[] args) {

        System.out.println("===== DECORATOR PATTERN DEMO (Creating a complex order) =====");

        Coffee myCoffee = new SimpleCoffee();

        myCoffee = new MilkDecorator(myCoffee);


        myCoffee = new SyrupDecorator(myCoffee);

        System.out.println("Customized Coffee Details:");
        System.out.println("  Description: " + myCoffee.getDescription());
        System.out.println("  Final Cost: $" + String.format("%.2f", myCoffee.getCost()));


        System.out.println("\n======= FACADE PATTERN DEMO (Placing the order) =========");

        CoffeeOrderFacade orderSystem = new CoffeeOrderFacade();

        boolean success = orderSystem.placeOrder(myCoffee);

        if (success) {
            System.out.println("\nOrder final status: COMPLETED.");
        } else {
            System.out.println("\nOrder final status: FAILED. Check error logs above.");
        }
    }
}