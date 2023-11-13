package christmas.dto;

import christmas.constant.badge.Badge;
import christmas.model.EventBadge;
import java.util.Objects;

public record EventBadgeDto(
        Badge badge
) {
    public static EventBadgeDto from(final EventBadge eventBadge) {
        Objects.requireNonNull(eventBadge);

        return new EventBadgeDto(eventBadge.badge());
    }

    public static EventBadgeDto from(final Badge badge) {
        Objects.requireNonNull(badge);

        return new EventBadgeDto(badge);
    }

    @Override
    public String toString() {
        return badge.getName();
    }
}
