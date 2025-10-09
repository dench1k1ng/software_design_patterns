package client;

import finance.FinancialValue;

public class PaymentProcessor {

    public void processPayment(FinancialValue value) {
        System.out.println("--- Payment Processing Started ---");
        System.out.println("Payment value: " + value.getFormattedValue());
        System.out.println("Internal amount: " + value.getValue());
        System.out.println("Payment processed for " + value.getCurrencyCode() + " successfully.");
        System.out.println("--- Payment Processing Complete ---");
    }
}