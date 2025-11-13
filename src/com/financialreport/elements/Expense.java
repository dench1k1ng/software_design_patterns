package com.financialreport.elements;

import com.financialreport.visitors.FinancialVisitor;

public class Expense implements FinancialElement {

    private final double amount;
    private final String category;

    public Expense(double amount, String category) {
        if (amount < 0) {
            throw new IllegalArgumentException("Expense amount cannot be negative");
        }
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Expense category cannot be null or empty");
        }

        this.amount = amount;
        this.category = category.trim();
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public void accept(FinancialVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return String.format("Expense{amount=%.2f, category='%s'}", amount, category);
    }
}
