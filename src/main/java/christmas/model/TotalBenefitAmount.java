package christmas.model;

import java.math.BigDecimal;
import java.util.Objects;

public record TotalBenefitAmount(
        BigDecimal amount
) {
    public static TotalBenefitAmount from(final Benefits benefits) {
        Objects.requireNonNull(benefits);

        return benefits.calculateTotalAmount();
    }

    public EventBadge calculateEventBadge() {
        return EventBadge.from(this);
    }
}
