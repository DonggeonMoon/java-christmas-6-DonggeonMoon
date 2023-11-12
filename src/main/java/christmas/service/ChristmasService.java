package christmas.service;

import christmas.dto.BenefitsDto;
import christmas.dto.GiveawayMenuDto;
import christmas.dto.OrderedMenuDto;
import christmas.dto.PreDiscountAmountDto;
import christmas.dto.VisitDateDto;
import christmas.model.Benefits;
import christmas.model.GiveawayMenu;
import christmas.model.OrderedMenu;
import christmas.model.PreDiscountAmount;
import christmas.model.VisitDate;

public class ChristmasService {
    private ChristmasService() {
    }

    public static ChristmasService create() {
        return new ChristmasService();
    }

    public VisitDateDto generateVisitDate(int inputDay) {
        VisitDate visitDate = VisitDate.from(inputDay);
        return VisitDateDto.from(visitDate);
    }

    public OrderedMenuDto generateOrderedMenu(String inputMenuAndCount) {
        OrderedMenu orderedMenu = OrderedMenu.from(inputMenuAndCount);
        return OrderedMenuDto.from(orderedMenu);
    }

    public PreDiscountAmountDto generatePreDiscountAmount(OrderedMenuDto orderedMenuDto) {
        OrderedMenu orderedMenu = orderedMenuDto.toEntity();
        PreDiscountAmount preDiscountAmount = PreDiscountAmount.from(orderedMenu);

        return PreDiscountAmountDto.from(preDiscountAmount);
    }

    public BenefitsDto generateBenefits(VisitDateDto visitDateDto, OrderedMenuDto orderedMenuDto) {
        VisitDate visitDate = visitDateDto.toEntity();
        OrderedMenu orderedMenu = orderedMenuDto.toEntity();
        Benefits benefits = Benefits.from(visitDate, orderedMenu);
        return BenefitsDto.from(benefits);
    }

    public GiveawayMenuDto generateGiveAway(BenefitsDto benefitsDto) {
        Benefits benefits = benefitsDto.toEntity();
        GiveawayMenu giveawayMenu = GiveawayMenu.from(benefits);
        return GiveawayMenuDto.from(giveawayMenu);
    }
}
