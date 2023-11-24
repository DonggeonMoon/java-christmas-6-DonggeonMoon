package christmas.dto;

import java.util.Objects;

public record EventBenefitPreviewDtos(
        OrderDto orderDto,
        PreDiscountAmountDto preDiscountAmountDto,
        BenefitsDto benefitsDto,
        GiveawayMenuDto giveawayMenuDto,
        TotalBenefitAmountDto totalBenefitAmountDto,
        PostDiscountAmountDto postDiscountAmountDto,
        EventBadgeDto eventBadgeDto
) {
    public static EventBenefitPreviewDtos of(
            OrderDto orderDto,
            PreDiscountAmountDto preDiscountAmountDto,
            BenefitsDto benefitsDto,
            GiveawayMenuDto giveawayMenuDto,
            TotalBenefitAmountDto totalBenefitAmountDto,
            PostDiscountAmountDto postDiscountAmountDto,
            EventBadgeDto eventBadgeDto
    ) {
        Objects.requireNonNull(orderDto);
        Objects.requireNonNull(preDiscountAmountDto);
        Objects.requireNonNull(benefitsDto);
        Objects.requireNonNull(giveawayMenuDto);
        Objects.requireNonNull(totalBenefitAmountDto);
        Objects.requireNonNull(postDiscountAmountDto);
        Objects.requireNonNull(eventBadgeDto);

        return new EventBenefitPreviewDtos(
                orderDto,
                preDiscountAmountDto,
                benefitsDto,
                giveawayMenuDto,
                totalBenefitAmountDto,
                postDiscountAmountDto,
                eventBadgeDto
        );
    }
}
