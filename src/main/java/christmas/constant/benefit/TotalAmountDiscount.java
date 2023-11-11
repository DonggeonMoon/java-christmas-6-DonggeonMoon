package christmas.constant.benefit;

import java.math.BigDecimal;
import java.util.function.Function;

public enum TotalAmountDiscount implements Discount {
    SPECIAL("특별 할인", (BigDecimal totalAmount) -> true);

    private final String name;
    private final Function<BigDecimal, Boolean> condition;

    TotalAmountDiscount(final String name, final Function<BigDecimal, Boolean> condition) {
        this.name = name;
        this.condition = condition;
    }

    public String getName() {
        return name;
    }
}
