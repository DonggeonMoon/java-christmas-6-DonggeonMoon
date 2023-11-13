package christmas.controller;

import christmas.dto.BenefitsDto;
import christmas.dto.EventBadgeDto;
import christmas.dto.GiveawayMenuDto;
import christmas.dto.OrderDto;
import christmas.dto.PostDiscountAmountDto;
import christmas.dto.PreDiscountAmountDto;
import christmas.dto.TotalBenefitAmountDto;
import christmas.dto.VisitDateDto;
import christmas.service.ChristmasService;
import christmas.view.ChristmasInputView;
import christmas.view.ChristmasOutputView;

public class ChristmasController extends AbstractRetry {
    private final ChristmasOutputView outputView;
    private final ChristmasInputView inputView;
    private final ChristmasService service;

    private ChristmasController(
            final ChristmasOutputView outputView,
            final ChristmasInputView inputView,
            final ChristmasService service
    ) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.service = service;
    }

    public static ChristmasController from(
            final ChristmasOutputView outputView,
            final ChristmasInputView inputView,
            final ChristmasService service
    ) {
        return new ChristmasController(outputView, inputView, service);
    }

    public void start() {
        showEventPlannerMessage();

        VisitDateDto visitDateDto = askExpectedVisitDate();
        OrderDto orderDto = askMenuAndCount();

        showEventBenefitPreview(orderDto, visitDateDto);
    }

    private void showEventPlannerMessage() {
        outputView.printEventPlannerMessage();
    }

    private VisitDateDto askExpectedVisitDate() {
        return run(() -> {
            int inputDay = inputView.readVisitDate();
            return service.generateVisitDate(inputDay);
        });
    }

    private OrderDto askMenuAndCount() {
        return run(() -> {
            String inputMenuAndCount = inputView.readMenuAndCount();
            return service.generateOrderedMenu(inputMenuAndCount);
        });
    }

    private void showEventBenefitPreview(
            final OrderDto orderDto,
            final VisitDateDto visitDateDto
    ) {
        outputView.printEventBenefitPreview();

        showOrderedMenu(orderDto);
        PreDiscountAmountDto preDiscountAmountDto = showPreDiscountAmount(orderDto);

        BenefitsDto benefitsDto = showGiveawayAndBenefit(orderDto, visitDateDto);

        TotalBenefitAmountDto totalBenefitAmountDto = showTotalBenefitAmount(benefitsDto);
        showPostDiscountAmount(preDiscountAmountDto, totalBenefitAmountDto);

        showEventBadge(totalBenefitAmountDto);
    }

    private void showOrderedMenu(final OrderDto orderDto) {
        outputView.printOrderedMenu(orderDto);
    }

    private PreDiscountAmountDto showPreDiscountAmount(final OrderDto orderDto) {
        PreDiscountAmountDto preDiscountAmountDto = service.generatePreDiscountAmount(orderDto);
        outputView.printPreDiscountAmount(preDiscountAmountDto);
        return preDiscountAmountDto;
    }

    private BenefitsDto showGiveawayAndBenefit(
            final OrderDto orderDto,
            final VisitDateDto visitDateDto
    ) {
        BenefitsDto benefitsDto = service.generateBenefits(visitDateDto, orderDto);
        GiveawayMenuDto giveawayMenuDto = service.generateGiveAway(benefitsDto);
        outputView.printGiveaway(giveawayMenuDto);
        outputView.printBenefits(benefitsDto);
        return benefitsDto;
    }

    private TotalBenefitAmountDto showTotalBenefitAmount(final BenefitsDto benefitsDto) {
        TotalBenefitAmountDto totalBenefitAmountDto = service.generateTotalBenefitAmount(benefitsDto);
        outputView.printTotalBenefitAmount(totalBenefitAmountDto);
        return totalBenefitAmountDto;
    }

    private void showPostDiscountAmount(
            final PreDiscountAmountDto preDiscountAmountDto,
            final TotalBenefitAmountDto totalBenefitAmountDto
    ) {
        PostDiscountAmountDto postDiscountAmountDto = service.generatePostDiscountAmount(
                preDiscountAmountDto,
                totalBenefitAmountDto
        );
        outputView.printPostDiscountAmount(postDiscountAmountDto);
    }

    private void showEventBadge(final TotalBenefitAmountDto totalBenefitAmountDto) {
        EventBadgeDto eventBadgeDto = service.generateBadge(totalBenefitAmountDto);
        outputView.printBadge(eventBadgeDto);
    }
}
