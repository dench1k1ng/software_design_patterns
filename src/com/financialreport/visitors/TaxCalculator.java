package com.financialreport.visitors;

import com.financialreport.elements.Revenue;
import com.financialreport.elements.Expense;
import com.financialreport.elements.Investment;

public class TaxCalculator implements FinancialVisitor {

    private static final double REVENUE_TAX_RATE = 0.15;
    private static final double EXPENSE_DEDUCTION_RATE = 0.05;
    private static final double INVESTMENT_TAX_RATE = 0.10;

    private double totalTaxLiability;

    public TaxCalculator() {
        this.totalTaxLiability = 0.0;
    }

    @Override
    public void visit(Revenue revenue) {
        double tax = revenue.getAmount() * REVENUE_TAX_RATE;
        totalTaxLiability += tax;
    }

    @Override
    public void visit(Expense expense) {
        double deduction = expense.getAmount() * EXPENSE_DEDUCTION_RATE;
        totalTaxLiability -= deduction;
    }

    @Override
    public void visit(Investment investment) {
        double taxableAmount = investment.getAmount() * investment.getRiskFactor();
        double tax = taxableAmount * INVESTMENT_TAX_RATE;
        totalTaxLiability += tax;
    }

    public double getTotalTaxLiability() {
        return totalTaxLiability;
    }

    public void reset() {
        this.totalTaxLiability = 0.0;
    }

    public String getFormattedTaxLiability() {
        return String.format("Total Tax Liability: $%.2f", totalTaxLiability);
    }
}
