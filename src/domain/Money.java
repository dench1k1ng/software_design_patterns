package domain;

import java.math.BigDecimal;
import java.util.Objects;

public final class Money {
    private final BigDecimal amount;
    private final String currency; // ISO 4217, e.g. "USD", "KZT"

    public Money(BigDecimal amount, String currency) {
        if (amount == null || amount.signum() < 0) {
            throw new IllegalArgumentException("Amount must be non-negative");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Currency is required");
        }
        this.amount = amount;
        this.currency = currency.toUpperCase();
    }

    public BigDecimal amount() { return amount; }
    public String currency() { return currency; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        // Use compareTo for BigDecimal equality check
        return amount.compareTo(money.amount) == 0 && currency.equals(money.currency);
    }

    @Override public int hashCode() { return Objects.hash(amount, currency); }

    @Override public String toString() { return amount + " " + currency; }
}