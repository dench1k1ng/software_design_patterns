package com.financialreport.elements;

import com.financialreport.interfaces.IFinancialVisitor;

public interface FinancialElement {
    void accept(IFinancialVisitor visitor);
}
