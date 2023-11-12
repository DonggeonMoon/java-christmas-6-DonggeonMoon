package christmas.controller;

import christmas.dto.BenefitsDto;
import christmas.dto.GiveawayMenuDto;
import christmas.dto.OrderedMenuDto;
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

    public ChristmasController(final ChristmasOutputView outputView,
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
        outputView.printEventPlannerMessage();
        VisitDateDto visitDateDto = run(() -> {
            int inputDay = inputView.readVisitDate();
            return service.generateVisitDate(inputDay);
        });

        OrderedMenuDto orderedMenuDto = run(() -> {
            String inputMenuAndCount = inputView.readMenuAndCount();
            return service.generateOrderedMenu(inputMenuAndCount);
        });
        outputView.printEventBenefitPreview();
        outputView.printOrderedMenu(orderedMenuDto);
        PreDiscountAmountDto preDiscountAmountDto = service.generatePreDiscountAmount(orderedMenuDto);
        outputView.printPreDiscountAmount(preDiscountAmountDto);
        BenefitsDto benefitsDto = service.generateBenefits(visitDateDto, orderedMenuDto);
        GiveawayMenuDto giveawayMenuDto = service.generateGiveAway(benefitsDto);
        outputView.printGiveaway(giveawayMenuDto);
        outputView.printBenefits(benefitsDto);
        TotalBenefitAmountDto totalBenefitAmountDto = service.generateTotalBenefitAmount(benefitsDto);
        outputView.printTotalBenefitAmount(totalBenefitAmountDto);
        PostDiscountAmountDto postDiscountAmountDto = service.generatePostDiscountAmount(
                preDiscountAmountDto,
                totalBenefitAmountDto
        );

    }
}
