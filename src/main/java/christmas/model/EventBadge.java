package christmas.model;

import christmas.constant.Badge;

public record EventBadge(
        Badge badge
) {
    public static EventBadge from(final TotalBenefitAmount totalBenefitAmount) {
        return new EventBadge(Badge.from(totalBenefitAmount));
    }
}
