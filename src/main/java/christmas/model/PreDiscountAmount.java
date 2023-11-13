package christmas.model;

import java.math.BigDecimal;
import java.util.Objects;

public record PreDiscountAmount(
        BigDecimal amount
) {
    public static PreDiscountAmount from(final BigDecimal amount) {
        Objects.requireNonNull(amount);

        return new PreDiscountAmount(amount);
    }

    public static PreDiscountAmount from(final Order order) {
        Objects.requireNonNull(order);

        return order.calculatePreDiscountAmount();
    }

    public boolean isGreaterThan(final BigDecimal amount) {
        Objects.requireNonNull(amount);

        return this.amount
                .compareTo(amount) > 0;
    }

    public PostDiscountAmount subtract(final TotalBenefitAmount totalBenefitAmount) {
        Objects.requireNonNull(totalBenefitAmount);

        return PostDiscountAmount.from(
                this.subtractAndReturnInBigDecimal(totalBenefitAmount)
        );
    }

    private BigDecimal subtractAndReturnInBigDecimal(final TotalBenefitAmount totalBenefitAmount) {
        return this.amount
                .subtract(
                        totalBenefitAmount.amount()
                );
    }
}
