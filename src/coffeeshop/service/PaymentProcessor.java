package coffeeshop.service;

public class PaymentProcessor {
    public boolean processPayment(double amount) {
        System.out.println("  [Payment] Initiating payment for $" + String.format("%.2f", amount));
        if (amount > 0 && Math.random() > 0.05) {
            System.out.println("  [Payment] Transaction successful. Charged $" + String.format("%.2f", amount));
            return true;
        } else {
            System.err.println("  [Payment] ERROR: Payment failed or insufficient funds.");
            return false;
        }
    }
}
