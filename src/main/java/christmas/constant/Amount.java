package christmas.constant;

import java.math.BigDecimal;

public enum Amount {
    WEEKDAYS_DISCOUNT_UNIT(BigDecimal.valueOf(2023)),
    WEEKEND_DISCOUNT_UNIT(BigDecimal.valueOf(2023)),
    SPECIAL_DISCOUNT_UNIT(BigDecimal.valueOf(1000)),
    GIVEAWAY_CRITERIA(BigDecimal.valueOf(120000));

    private final BigDecimal value;

    Amount(final BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}
