package christmas.controller;

import christmas.dto.EventBenefitPreviewDtos;
import christmas.dto.OrderDto;
import christmas.dto.VisitDateDto;
import christmas.service.ChristmasService;
import christmas.view.ChristmasInputView;
import christmas.view.ChristmasOutputView;
import java.util.Objects;

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
        Objects.requireNonNull(outputView);
        Objects.requireNonNull(inputView);
        Objects.requireNonNull(service);

        return new ChristmasController(outputView, inputView, service);
    }

    public void start() {
        showEventPlannerMessage();

        VisitDateDto visitDateDto = askExpectedVisitDate();

        OrderDto orderDto = askMenuAndCount();

        EventBenefitPreviewDtos eventBenefitPreviewDtos = calculateBenefitPreviewDtos(visitDateDto, orderDto);

        showEventBenefitPreview(eventBenefitPreviewDtos);
    }

    private void showEventPlannerMessage() {
        outputView.printEventPlannerMessage();
    }

    private VisitDateDto askExpectedVisitDate() {
        return run(() -> {
            int inputDay = inputView.readVisitDate();
            return service.generateVisitDateFrom(inputDay);
        });
    }

    private OrderDto askMenuAndCount() {
        return run(() -> {
            String inputMenuAndCount = inputView.readMenuAndCount();
            return service.generateOrderedMenuFrom(inputMenuAndCount);
        });
    }

    private EventBenefitPreviewDtos calculateBenefitPreviewDtos(
            final VisitDateDto visitDateDto,
            final OrderDto orderDto
    ) {
        return service.generateEventBenefitPreviewDtos(visitDateDto, orderDto);
    }

    private void showEventBenefitPreview(final EventBenefitPreviewDtos eventBenefitPreviewDtos) {
        outputView.printEventBenefitPreview();
        outputView.printOrderedMenu(eventBenefitPreviewDtos.orderDto());
        outputView.printPreDiscountAmount(eventBenefitPreviewDtos.preDiscountAmountDto());
        outputView.printGiveaway(eventBenefitPreviewDtos.giveawayMenuDto());
        outputView.printBenefits(eventBenefitPreviewDtos.benefitsDto());
        outputView.printTotalBenefitAmount(eventBenefitPreviewDtos.totalBenefitAmountDto());
        outputView.printPostDiscountAmount(eventBenefitPreviewDtos.postDiscountAmountDto());
        outputView.printBadge(eventBenefitPreviewDtos.eventBadgeDto());
    }
}
