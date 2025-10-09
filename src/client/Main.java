package client;

import domain.Money;
import finance.FinancialValue;
import finance.MoneyAdapter;
import java.math.BigDecimal;

class Main {
    public static void main(String[] args) {

        Money euroAmount = new Money(new BigDecimal("1234.56"), "EUR");
        Money usdAmount = new Money(new BigDecimal("500.00"), "USD");

        FinancialValue adaptedEuro = new MoneyAdapter(euroAmount);
        FinancialValue adaptedUSD = new MoneyAdapter(usdAmount);

        PaymentProcessor processor = new PaymentProcessor();

        System.out.println("Processing Euro Payment:");
        processor.processPayment(adaptedEuro);

        System.out.println("\nProcessing USD Payment:");
        processor.processPayment(adaptedUSD);
    }
}