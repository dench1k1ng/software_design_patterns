package finance;

import java.math.BigDecimal;


public interface FinancialValue {
    BigDecimal getValue();
    String getCurrencyCode();
    String getFormattedValue();
}