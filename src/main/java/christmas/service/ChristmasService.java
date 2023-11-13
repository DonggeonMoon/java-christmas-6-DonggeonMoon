package christmas.service;

import christmas.dto.BenefitsDto;
import christmas.dto.EventBadgeDto;
import christmas.dto.GiveawayMenuDto;
import christmas.dto.OrderDto;
import christmas.dto.PostDiscountAmountDto;
import christmas.dto.PreDiscountAmountDto;
import christmas.dto.TotalBenefitAmountDto;
import christmas.dto.VisitDateDto;
import christmas.model.Benefits;
import christmas.model.Order;
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

        return OrderDto.from(
                Order.from(inputMenuAndCount)
        );
    }

    public PreDiscountAmountDto generatePreDiscountAmountFrom(final OrderDto orderDto) {
        Objects.requireNonNull(orderDto);

        return PreDiscountAmountDto.from(
                orderDto
                        .toModel()
                        .calculatePreDiscountAmount()
        );
    }

    public GiveawayMenuDto generateGiveAwayMenuFrom(final BenefitsDto benefitsDto) {
        Objects.requireNonNull(benefitsDto);

        return GiveawayMenuDto.from(
                benefitsDto
                        .toModel()
                        .calculateGiveawayMenu()
        );
    }

    public PostDiscountAmountDto generatePostDiscountAmount(
            final PreDiscountAmountDto preDiscountAmountDto,
            final TotalBenefitAmountDto totalBenefitAmountDto
    ) {
        Objects.requireNonNull(preDiscountAmountDto);
        Objects.requireNonNull(totalBenefitAmountDto);

        totalBenefitAmountDto.toModel();
        return PostDiscountAmountDto.from(
                preDiscountAmountDto.
                        toModel()
                        .subtract(
                                totalBenefitAmountDto.toModel()
                        )
        );
    }

    public BenefitsDto generateBenefitsFrom(
            final VisitDateDto visitDateDto,
            final OrderDto orderDto
    ) {
        Objects.requireNonNull(visitDateDto);
        Objects.requireNonNull(orderDto);

        return BenefitsDto.from(
                Benefits.from(
                        visitDateDto.toModel(),
                        orderDto.toModel()
                )
        );
    }

    public TotalBenefitAmountDto generateTotalBenefitFrom(final BenefitsDto benefitsDto) {
        Objects.requireNonNull(benefitsDto);

        return TotalBenefitAmountDto.from(
                benefitsDto
                        .toModel()
                        .calculateTotalBenefitAmount()
        );
    }

    public EventBadgeDto generateEventBadgeFrom(final TotalBenefitAmountDto totalBenefitAmountDto) {
        Objects.requireNonNull(totalBenefitAmountDto);

        return EventBadgeDto.from(
                totalBenefitAmountDto
                        .toModel()
                        .calculateEventBadge()
        );
    }
}
