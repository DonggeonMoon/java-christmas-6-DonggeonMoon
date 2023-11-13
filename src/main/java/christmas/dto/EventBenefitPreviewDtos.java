package christmas.dto;

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
