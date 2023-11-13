package christmas.service;

import christmas.dto.BenefitsDto;
import christmas.dto.EventBadgeDto;
import christmas.dto.EventBenefitPreviewDtos;
import christmas.dto.GiveawayMenuDto;
import christmas.dto.OrderDto;
import christmas.dto.PostDiscountAmountDto;
import christmas.dto.PreDiscountAmountDto;
import christmas.dto.TotalBenefitAmountDto;
import christmas.dto.VisitDateDto;
import christmas.model.Benefits;
import christmas.model.EventBadge;
import christmas.model.GiveawayMenu;
import christmas.model.Order;
import christmas.model.PostDiscountAmount;
import christmas.model.PreDiscountAmount;
import christmas.model.TotalBenefitAmount;
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

        Order order = Order.from(inputMenuAndCount);
        return OrderDto.from(order);
    }

    public EventBenefitPreviewDtos generateEventBenefitPreviewDtos(
            final VisitDateDto visitDateDto,
            final OrderDto orderDto
    ) {
        Objects.requireNonNull(visitDateDto);
        Objects.requireNonNull(orderDto);

        BenefitsDto benefitsDto = generateBenefitsFrom(visitDateDto, orderDto);
        GiveawayMenuDto giveawayMenuDto = generateGiveawayFrom(benefitsDto);

        PreDiscountAmountDto preDiscountAmountDto = generatePreDiscountAmountFrom(orderDto);
        TotalBenefitAmountDto totalBenefitAmountDto = generateTotalBenefitAmountFrom(benefitsDto);
        PostDiscountAmountDto postDiscountAmountDto = generatePostDiscountAmountFrom(
                preDiscountAmountDto,
                totalBenefitAmountDto
        );
        EventBadgeDto eventBadgeDto = generateEventBadgeFrom(totalBenefitAmountDto);
        return EventBenefitPreviewDtos.of(
                orderDto, preDiscountAmountDto, benefitsDto, giveawayMenuDto,
                totalBenefitAmountDto, postDiscountAmountDto, eventBadgeDto
        );
    }

    private PreDiscountAmountDto generatePreDiscountAmountFrom(final OrderDto orderDto) {
        Order order = orderDto.toModel();
        PreDiscountAmount preDiscountAmount = PreDiscountAmount.from(order);
        return PreDiscountAmountDto.from(preDiscountAmount);
    }

    private BenefitsDto generateBenefitsFrom(
            final VisitDateDto visitDateDto,
            final OrderDto orderDto
    ) {
        VisitDate visitDate = visitDateDto.toModel();
        Order order = orderDto.toModel();
        Benefits benefits = Benefits.from(visitDate, order);
        return BenefitsDto.from(benefits);
    }

    private GiveawayMenuDto generateGiveawayFrom(final BenefitsDto benefitsDto) {
        Benefits benefits = benefitsDto.toModel();
        GiveawayMenu giveawayMenu = GiveawayMenu.from(benefits);
        return GiveawayMenuDto.from(giveawayMenu);
    }

    private TotalBenefitAmountDto generateTotalBenefitAmountFrom(final BenefitsDto benefitsDto) {
        Benefits benefits = benefitsDto.toModel();
        TotalBenefitAmount totalBenefitAmount = TotalBenefitAmount.from(benefits);
        return TotalBenefitAmountDto.from(totalBenefitAmount);
    }

    private PostDiscountAmountDto generatePostDiscountAmountFrom(
            final PreDiscountAmountDto preDiscountAmountDto,
            final TotalBenefitAmountDto totalBenefitAmountDto
    ) {
        PreDiscountAmount preDiscountAmount = preDiscountAmountDto.toModel();
        TotalBenefitAmount totalBenefitAmount = totalBenefitAmountDto.toModel();
        PostDiscountAmount postDiscountAmount = PostDiscountAmount.of(preDiscountAmount, totalBenefitAmount);
        return PostDiscountAmountDto.from(postDiscountAmount);
    }

    private EventBadgeDto generateEventBadgeFrom(final TotalBenefitAmountDto totalBenefitAmountDto) {
        TotalBenefitAmount totalBenefitAmount = totalBenefitAmountDto.toModel();
        EventBadge eventBadge = EventBadge.from(totalBenefitAmount);
        return EventBadgeDto.from(eventBadge);
    }
}
