package com.financialreport.elements;

import com.financialreport.visitors.FinancialVisitor;

public interface FinancialElement {
    void accept(FinancialVisitor visitor);
}
