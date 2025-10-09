package finance;

import domain.Money;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Objects;

public final class MoneyAdapter implements FinancialValue {

    private final Money adapteeMoney;

    public MoneyAdapter(Money adapteeMoney) {
        this.adapteeMoney = Objects.requireNonNull(adapteeMoney, "Money object to adapt cannot be null.");
    }

    @Override
    public BigDecimal getValue() {
        return adapteeMoney.amount();
    }

    @Override
    public String getCurrencyCode() {
        return adapteeMoney.currency();
    }
    @Override
    public String getFormattedValue() {
        try {
            Currency currency = Currency.getInstance(getCurrencyCode());
            Locale locale = getLocaleForCurrency(currency);

            NumberFormat format = NumberFormat.getCurrencyInstance(locale);
            // Ensure consistency with the currency's standard decimals
            format.setMinimumFractionDigits(currency.getDefaultFractionDigits());
            format.setMaximumFractionDigits(currency.getDefaultFractionDigits());

            return format.format(getValue());
        } catch (IllegalArgumentException e) {
            // Fallback for unknown/unsupported currency codes
            return getValue() + " " + getCurrencyCode();
        }
    }


    private Locale getLocaleForCurrency(Currency currency) {
        // Find a Locale that uses this currency
        for (Locale locale : Locale.getAvailableLocales()) {
            try {
                if (currency.equals(Currency.getInstance(locale))) {
                    return locale;
                }
            } catch (Exception ignored) {
            }
        }
        return Locale.US;
    }
}