package com.financialreport.elements;

import com.financialreport.visitors.FinancialVisitor;

public class Investment implements FinancialElement {

    private final double amount;
    private final double riskFactor;

    public Investment(double amount, double riskFactor) {
        if (amount < 0) {
            throw new IllegalArgumentException("Investment amount cannot be negative");
        }
        if (riskFactor < 0.0 || riskFactor > 1.0) {
            throw new IllegalArgumentException("Risk factor must be between 0.0 and 1.0");
        }

        this.amount = amount;
        this.riskFactor = riskFactor;
    }

    public double getAmount() {
        return amount;
    }

    public double getRiskFactor() {
        return riskFactor;
    }

    @Override
    public void accept(FinancialVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return String.format("Investment{amount=%.2f, riskFactor=%.2f}", amount, riskFactor);
    }
}
