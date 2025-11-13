package com.financialreport.demo;

import com.financialreport.elements.*;
import com.financialreport.interfaces.IFinancialVisitor;
import com.financialreport.visitors.*;
import java.util.ArrayList;
import java.util.List;

public class FinancialReportDemo {

    public static void main(String[] args) {
        System.out.println("=== Financial Report Element Processor ===");
        System.out.println("Demonstrating Visitor Pattern Implementation\n");

        List<FinancialElement> financialElements = createSampleFinancialData();

        System.out.println("Financial Elements:");
        System.out.println("==================");
        displayFinancialElements(financialElements);

        System.out.println("\nTax Calculation:");
        System.out.println("================");
        TaxCalculator taxCalculator = new TaxCalculator();
        applyVisitor(financialElements, taxCalculator);
        System.out.println(taxCalculator.getFormattedTaxLiability());
        displayTaxBreakdown(financialElements);

        System.out.println("\nGenerated Report:");
        System.out.println("=================");
        ReportGenerator reportGenerator = new ReportGenerator();
        applyVisitor(financialElements, reportGenerator);
        System.out.println(reportGenerator.getReportOutput());

        System.out.println("\nDemonstrating Extensibility:");
        System.out.println("=============================");
        demonstrateExtensibility();
    }

    private static List<FinancialElement> createSampleFinancialData() {
        List<FinancialElement> elements = new ArrayList<>();

        elements.add(new Revenue(150000.0, "Sales"));
        elements.add(new Revenue(75000.0, "Service"));
        elements.add(new Revenue(25000.0, "Licensing"));

        elements.add(new Expense(80000.0, "Salaries"));
        elements.add(new Expense(15000.0, "Utilities"));
        elements.add(new Expense(12000.0, "Marketing"));
        elements.add(new Expense(8000.0, "Office Supplies"));

        elements.add(new Investment(100000.0, 0.3));
        elements.add(new Investment(50000.0, 0.7));
        elements.add(new Investment(200000.0, 0.1));

        return elements;
    }

    private static void displayFinancialElements(List<FinancialElement> elements) {
        for (int i = 0; i < elements.size(); i++) {
            System.out.printf("%2d. %s%n", i + 1, elements.get(i));
        }
    }

    private static void applyVisitor(List<FinancialElement> elements, IFinancialVisitor visitor) {
        for (FinancialElement element : elements) {
            element.accept(visitor);
        }
    }

    private static void displayTaxBreakdown(List<FinancialElement> elements) {
        System.out.println("\nTax Calculation Breakdown:");
        System.out.println("- Revenue: 15% tax rate");
        System.out.println("- Expense: 5% tax deduction");
        System.out.println("- Investment: 10% tax on (amount × risk factor)");

        double totalRevenue = 0, totalExpense = 0, totalInvestment = 0;

        for (FinancialElement element : elements) {
            if (element instanceof Revenue) {
                totalRevenue += ((Revenue) element).getAmount();
            } else if (element instanceof Expense) {
                totalExpense += ((Expense) element).getAmount();
            } else if (element instanceof Investment) {
                Investment inv = (Investment) element;
                totalInvestment += inv.getAmount() * inv.getRiskFactor();
            }
        }

        System.out.printf("Total Revenue: $%.2f (Tax: $%.2f)%n",
                totalRevenue, totalRevenue * 0.15);
        System.out.printf("Total Expenses: $%.2f (Deduction: $%.2f)%n",
                totalExpense, totalExpense * 0.05);
        System.out.printf("Total Taxable Investment: $%.2f (Tax: $%.2f)%n",
                totalInvestment, totalInvestment * 0.10);
    }

    private static void demonstrateExtensibility() {
        System.out.println("The Visitor Pattern allows easy addition of new operations:");
        System.out.println("- New visitors can be added without modifying FinancialElement classes");
        System.out.println("- Examples of additional visitors: AuditChecker, ComplianceValidator, CurrencyConverter");
        System.out.println("- This demonstrates the Open/Closed Principle in action");

        List<FinancialElement> sample = List.of(
                new Revenue(1000.0, "Demo"),
                new Expense(500.0, "Demo"),
                new Investment(2000.0, 0.5));

        SimpleCounterVisitor counter = new SimpleCounterVisitor();
        applyVisitor(sample, counter);
        System.out.printf("Element count demonstration - Total elements processed: %d%n",
                counter.getCount());
    }

    private static class SimpleCounterVisitor implements IFinancialVisitor {
        private int count = 0;

        @Override
        public void visit(Revenue revenue) {
            count++;
        }

        @Override
        public void visit(Expense expense) {
            count++;
        }

        @Override
        public void visit(Investment investment) {
            count++;
        }

        public int getCount() {
            return count;
        }
    }
}
