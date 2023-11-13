package christmas.service;

import christmas.dto.BenefitsDto;
import christmas.dto.EventBadgeDto;
import christmas.dto.GiveawayMenuDto;
import christmas.dto.OrderDto;
import christmas.dto.PostDiscountAmountDto;
import christmas.dto.PreDiscountAmountDto;
import christmas.dto.TotalBenefitAmountDto;
import christmas.dto.VisitDateDto;
import christmas.model.VisitDate;
import java.util.Objects;

public class ChristmasService {
    private ChristmasService() {
    }

    public static ChristmasService create() {
        return new ChristmasService();
    }

    public VisitDateDto generateVisitDateFrom(final int inputDay) {
        VisitDate visitDate = VisitDate.from(inputDay);
        return VisitDateDto.from(visitDate);
    }

    public OrderDto generateOrderedMenuFrom(final String inputMenuAndCount) {
        Objects.requireNonNull(inputMenuAndCount);

        return OrderDto.from(inputMenuAndCount);
    }

    public PreDiscountAmountDto generatePreDiscountAmountFrom(final OrderDto orderDto) {
        Objects.requireNonNull(orderDto);

        return orderDto.calculatePreDiscountAmountDto();
    }

    public GiveawayMenuDto generateGiveAwayMenuFrom(final BenefitsDto benefitsDto) {
        Objects.requireNonNull(benefitsDto);

        return benefitsDto.calculateGiveawayMenuDto();
    }

    public PostDiscountAmountDto generatePostDiscountAmount(
            final PreDiscountAmountDto preDiscountAmountDto,
            final TotalBenefitAmountDto totalBenefitAmountDto
    ) {
        Objects.requireNonNull(preDiscountAmountDto);
        Objects.requireNonNull(totalBenefitAmountDto);

        totalBenefitAmountDto.toModel();
        return preDiscountAmountDto.calculatePostDiscountAmountDto(totalBenefitAmountDto);
    }

    public BenefitsDto generateBenefitsFrom(
            final VisitDateDto visitDateDto,
            final OrderDto orderDto
    ) {
        Objects.requireNonNull(visitDateDto);
        Objects.requireNonNull(orderDto);

        return orderDto.calculateBenefitsDtoFrom(visitDateDto);
    }

    public TotalBenefitAmountDto generateTotalBenefitFrom(final BenefitsDto benefitsDto) {
        Objects.requireNonNull(benefitsDto);

        return benefitsDto.calculateTotalBenefitAmountDto();
    }

    public EventBadgeDto generateEventBadgeFrom(final TotalBenefitAmountDto totalBenefitAmountDto) {
        Objects.requireNonNull(totalBenefitAmountDto);

        return totalBenefitAmountDto.calculateEventBadgeDto();
    }
}
