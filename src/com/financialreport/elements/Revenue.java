package com.financialreport.elements;

import com.financialreport.visitors.FinancialVisitor;

public class Revenue implements FinancialElement {

    private final double amount;
    private final String source;

    public Revenue(double amount, String source) {
        if (amount < 0) {
            throw new IllegalArgumentException("Revenue amount cannot be negative");
        }
        if (source == null || source.trim().isEmpty()) {
            throw new IllegalArgumentException("Revenue source cannot be null or empty");
        }

        this.amount = amount;
        this.source = source.trim();
    }

    public double getAmount() {
        return amount;
    }

    public String getSource() {
        return source;
    }

    @Override
    public void accept(FinancialVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return String.format("Revenue{amount=%.2f, source='%s'}", amount, source);
    }
}
