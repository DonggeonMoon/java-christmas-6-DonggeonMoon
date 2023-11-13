package christmas.model;

import java.math.BigDecimal;
import java.util.Objects;

public record TotalBenefitAmount(
        BigDecimal amount
) {
    public static TotalBenefitAmount from(final Benefits benefits) {
        Objects.requireNonNull(benefits);

        BigDecimal totalAmount = benefits.benefits()
                .values()
                .stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new TotalBenefitAmount(totalAmount);
    }
}
