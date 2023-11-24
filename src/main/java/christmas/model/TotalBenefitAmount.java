package christmas.model;

import java.math.BigDecimal;
import java.util.Objects;

public record TotalBenefitAmount(
        BigDecimal amount
) {
    public static TotalBenefitAmount from(BigDecimal amount) {
        Objects.requireNonNull(amount);

        return new TotalBenefitAmount(amount);
    }

    public EventBadge calculateEventBadge() {
        return EventBadge.from(this);
    }
}
