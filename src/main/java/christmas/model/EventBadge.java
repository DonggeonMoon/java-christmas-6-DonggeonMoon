package christmas.model;

import christmas.constant.badge.Badge;

public record EventBadge(
        Badge badge
) {
    public static EventBadge from(final TotalBenefitAmount totalBenefitAmount) {
        return new EventBadge(Badge.from(totalBenefitAmount));
    }
}
