package christmas.constant;

import java.math.BigDecimal;

public enum Amounts {
    WEEKDAYS_DISCOUNT_UNIT_AMOUNT(BigDecimal.valueOf(2023)),
    WEEKEND_DISCOUNT_UNIT_AMOUNT(BigDecimal.valueOf(2023)),
    SPECIAL_DISCOUNT_UNIT_AMOUNT(BigDecimal.valueOf(1000)),
    GIVEAWAY_CRITERIA_AMOUNT(BigDecimal.valueOf(120000));


    private final BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    Amounts(final BigDecimal amount) {
        this.amount = amount;
    }
}
