package com.financialreport.interfaces;

import com.financialreport.elements.Revenue;
import com.financialreport.elements.Expense;
import com.financialreport.elements.Investment;

public interface IFinancialVisitor {
    void visit(Revenue revenue);

    void visit(Expense expense);

    void visit(Investment investment);
}
