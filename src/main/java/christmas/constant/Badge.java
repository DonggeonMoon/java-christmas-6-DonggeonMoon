package christmas.constant;

import java.math.BigDecimal;
import java.util.function.Function;

public enum Badge {
    NONE("없음", benefitTotalAmount -> BigDecimal.valueOf(5000).compareTo(benefitTotalAmount) > 0),
    STAR("별", benefitTotalAmount ->
            BigDecimal.valueOf(5000).compareTo(benefitTotalAmount) <= 0
                    && BigDecimal.valueOf(10000).compareTo(benefitTotalAmount) > 0),
    TREE("트리", benefitTotalAmount ->
            BigDecimal.valueOf(10000).compareTo(benefitTotalAmount) <= 0
                    && BigDecimal.valueOf(20000).compareTo(benefitTotalAmount) > 0),
    SANTA("산타", benefitTotalAmount -> BigDecimal.valueOf(20000).compareTo(benefitTotalAmount) <= 0);

    private final String name;
    private final Function<BigDecimal, Boolean> condition;

    Badge(final String name, final Function<BigDecimal, Boolean> condition) {
        this.name = name;
        this.condition = condition;
    }

    public static Badge from(final BigDecimal discountAmount) {
        for (Badge badge : values()) {
            if (badge.condition.apply(discountAmount)) {
                return badge;
            }
        }
        return Badge.NONE;
    }

    public String getName() {
        return name;
    }
}
