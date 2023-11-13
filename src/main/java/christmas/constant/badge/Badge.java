package christmas.constant.badge;

import christmas.model.TotalBenefitAmount;
import java.math.BigDecimal;
import java.util.function.Function;

public enum Badge {
    NONE("없음", totalBenefitAmount -> BigDecimal.valueOf(5000).compareTo(totalBenefitAmount) > 0),
    STAR("별", totalBenefitAmount ->
            BigDecimal.valueOf(5000).compareTo(totalBenefitAmount) <= 0
                    && BigDecimal.valueOf(10000).compareTo(totalBenefitAmount) > 0),
    TREE("트리", totalBenefitAmount ->
            BigDecimal.valueOf(10000).compareTo(totalBenefitAmount) <= 0
                    && BigDecimal.valueOf(20000).compareTo(totalBenefitAmount) > 0),
    SANTA("산타", totalBenefitAmount -> BigDecimal.valueOf(20000).compareTo(totalBenefitAmount) <= 0);

    private final String name;
    private final Function<BigDecimal, Boolean> condition;

    Badge(final String name, final Function<BigDecimal, Boolean> condition) {
        this.name = name;
        this.condition = condition;
    }

    public static Badge from(final TotalBenefitAmount totalBenefitAmount) {
        for (Badge badge : values()) {
            if (badge.condition.apply(totalBenefitAmount.amount())) {
                return badge;
            }
        }
        return Badge.NONE;
    }

    public String getName() {
        return name;
    }
}
