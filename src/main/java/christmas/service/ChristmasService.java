package christmas.service;

import christmas.dto.EventBadgeDto;
import christmas.dto.BenefitsDto;
import christmas.dto.GiveawayMenuDto;
import christmas.dto.OrderDto;
import christmas.dto.PostDiscountAmountDto;
import christmas.dto.PreDiscountAmountDto;
import christmas.dto.TotalBenefitAmountDto;
import christmas.dto.VisitDateDto;
import christmas.model.EventBadge;
import christmas.model.Benefits;
import christmas.model.GiveawayMenu;
import christmas.model.Order;
import christmas.model.PostDiscountAmount;
import christmas.model.PreDiscountAmount;
import christmas.model.TotalBenefitAmount;
import christmas.model.VisitDate;

public class ChristmasService {
    private ChristmasService() {
    }

    public static ChristmasService create() {
        return new ChristmasService();
    }

    public VisitDateDto generateVisitDate(final int inputDay) {
        VisitDate visitDate = VisitDate.from(inputDay);
        return VisitDateDto.from(visitDate);
    }

    public OrderDto generateOrderedMenu(final String inputMenuAndCount) {
        Order order = Order.from(inputMenuAndCount);
        return OrderDto.from(order);
    }

    public PreDiscountAmountDto generatePreDiscountAmount(final OrderDto orderDto) {
        Order order = orderDto.toEntity();
        PreDiscountAmount preDiscountAmount = PreDiscountAmount.from(order);
        return PreDiscountAmountDto.from(preDiscountAmount);
    }

    public BenefitsDto generateBenefits(
            final VisitDateDto visitDateDto,
            final OrderDto orderDto
    ) {
        VisitDate visitDate = visitDateDto.toEntity();
        Order order = orderDto.toEntity();
        Benefits benefits = Benefits.from(visitDate, order);
        return BenefitsDto.from(benefits);
    }

    public GiveawayMenuDto generateGiveAway(final BenefitsDto benefitsDto) {
        Benefits benefits = benefitsDto.toEntity();
        GiveawayMenu giveawayMenu = GiveawayMenu.from(benefits);
        return GiveawayMenuDto.from(giveawayMenu);
    }

    public TotalBenefitAmountDto generateTotalBenefitAmount(final BenefitsDto benefitsDto) {
        Benefits benefits = benefitsDto.toEntity();
        TotalBenefitAmount totalBenefitAmount = TotalBenefitAmount.from(benefits);
        return TotalBenefitAmountDto.from(totalBenefitAmount);
    }

    public PostDiscountAmountDto generatePostDiscountAmount(
            final PreDiscountAmountDto preDiscountAmountDto,
            final TotalBenefitAmountDto totalBenefitAmountDto
    ) {
        PreDiscountAmount preDiscountAmount = preDiscountAmountDto.toEntity();
        TotalBenefitAmount totalBenefitAmount = totalBenefitAmountDto.toEntity();
        PostDiscountAmount postDiscountAmount = PostDiscountAmount.of(preDiscountAmount, totalBenefitAmount);
        return PostDiscountAmountDto.from(postDiscountAmount);
    }

    public EventBadgeDto generateBadge(final TotalBenefitAmountDto totalBenefitAmountDto) {
        TotalBenefitAmount totalBenefitAmount = totalBenefitAmountDto.toEntity();
        EventBadge eventBadge = EventBadge.from(totalBenefitAmount);
        return EventBadgeDto.from(eventBadge);
    }
}
