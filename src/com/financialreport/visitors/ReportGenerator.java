package com.financialreport.visitors;

import com.financialreport.elements.Revenue;
import com.financialreport.elements.Expense;
import com.financialreport.elements.Investment;

public class ReportGenerator implements IFinancialVisitor {

    private final StringBuilder reportOutput;

    public ReportGenerator() {
        this.reportOutput = new StringBuilder();
    }

    @Override
    public void visit(Revenue revenue) {
        String reportLine = String.format("Revenue - %s - Value: %.2f",
                revenue.getSource(),
                revenue.getAmount());
        appendReportLine(reportLine);
    }

    @Override
    public void visit(Expense expense) {
        String reportLine = String.format("Expense - %s - Value: %.2f",
                expense.getCategory(),
                expense.getAmount());
        appendReportLine(reportLine);
    }

    @Override
    public void visit(Investment investment) {
        String reportLine = String.format("Investment - Risk Factor %.2f - Value: %.2f",
                investment.getRiskFactor(),
                investment.getAmount());
        appendReportLine(reportLine);
    }

    private void appendReportLine(String reportLine) {
        if (reportOutput.length() > 0) {
            reportOutput.append(System.lineSeparator());
        }
        reportOutput.append(reportLine);
    }

    public String getReportOutput() {
        return reportOutput.toString();
    }

    public void reset() {
        reportOutput.setLength(0);
    }

    public boolean hasContent() {
        return reportOutput.length() > 0;
    }
}
