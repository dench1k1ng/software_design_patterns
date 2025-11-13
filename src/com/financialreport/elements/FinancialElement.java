package com.financialreport.elements;

import com.financialreport.visitors.IFinancialVisitor;

public interface FinancialElement {
    void accept(IFinancialVisitor visitor);
}
