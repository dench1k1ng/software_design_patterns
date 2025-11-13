package com.financialreport.visitors;

import com.financialreport.elements.Revenue;
import com.financialreport.elements.Expense;
import com.financialreport.elements.Investment;

public interface FinancialVisitor {
    void visit(Revenue revenue);

    void visit(Expense expense);

    void visit(Investment investment);
}
