package christmas.model;

import christmas.constant.badge.Badge;
import java.util.Objects;

public record EventBadge(
        Badge badge
) {
    public static EventBadge from(final TotalBenefitAmount totalBenefitAmount) {
        Objects.requireNonNull(totalBenefitAmount);

        return new EventBadge(Badge.from(totalBenefitAmount));
    }
}
