package christmas.dto;

import christmas.constant.Badge;
import christmas.model.EventBadge;

public record EventBadgeDto(
        Badge badge
) {
    public static EventBadgeDto from(final EventBadge eventBadge) {
        return new EventBadgeDto(eventBadge.badge());
    }

    public static EventBadgeDto from(final Badge badge) {
        return new EventBadgeDto(badge);
    }

    public EventBadge toEntity() {
        return new EventBadge(badge);
    }

    @Override
    public String toString() {
        return badge.getName() + "\n";
    }
}
