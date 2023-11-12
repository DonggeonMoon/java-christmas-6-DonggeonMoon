package christmas.dto;

import christmas.constant.Badge;

public record BadgeDto(
        Badge badge
) {
    public static BadgeDto from(Badge badge) {
        return new BadgeDto(badge);
    }

    public christmas.model.Badge toEntity() {
        return new christmas.model.Badge(badge);
    }
}
