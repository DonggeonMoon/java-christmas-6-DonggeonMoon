package christmas.model;

import java.math.BigDecimal;
import java.util.Objects;

public record PostDiscountAmount(
        BigDecimal amount
) {
    public static PostDiscountAmount from(final BigDecimal amount) {
        Objects.requireNonNull(amount);

        return new PostDiscountAmount(amount);
    }

    public static PostDiscountAmount of(
            final PreDiscountAmount preDiscountAmount,
            final TotalBenefitAmount totalBenefitAmount
    ) {
        Objects.requireNonNull(preDiscountAmount);
        Objects.requireNonNull(totalBenefitAmount);

        BigDecimal subtracted = preDiscountAmount.subtract(totalBenefitAmount);
        return new PostDiscountAmount(subtracted);
    }
}
