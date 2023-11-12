package christmas.model;

import java.math.BigDecimal;

public record TotalBenefitAmount(
        BigDecimal amount
) {
    public static TotalBenefitAmount from(Benefits benefits) {
        BigDecimal totalAmount = benefits.benefits()
                .values()
                .stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new TotalBenefitAmount(totalAmount);
    }
}
