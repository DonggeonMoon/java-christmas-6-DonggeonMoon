package christmas.view;

import static christmas.constant.string.Message.BADGE_PREFIX;
import static christmas.constant.string.Message.BENEFIT_PREFIX;
import static christmas.constant.string.Message.EVENT_BENEFIT_PREVIEW;
import static christmas.constant.string.Message.EVENT_PLANNER;
import static christmas.constant.string.Message.GIVEAWAY_PREFIX;
import static christmas.constant.string.Message.ORDERED_MENU_PREFIX;
import static christmas.constant.string.Message.POST_DISCOUNT_AMOUNT_PREFIX;
import static christmas.constant.string.Message.PRE_DISCOUNT_AMOUNT_PREFIX;
import static christmas.constant.string.Message.TOTAL_BENEFIT_AMOUNT_PREFIX;

import christmas.dto.BenefitsDto;
import christmas.dto.EventBadgeDto;
import christmas.dto.GiveawayMenuDto;
import christmas.dto.OrderDto;
import christmas.dto.PostDiscountAmountDto;
import christmas.dto.PreDiscountAmountDto;
import christmas.dto.TotalBenefitAmountDto;

public class ChristmasOutputView extends AbstractView {
    private ChristmasOutputView() {
    }

    public static ChristmasOutputView create() {
        return new ChristmasOutputView();
    }

    public void printEventPlannerMessage() {
        printMessage(EVENT_PLANNER);
    }

    public void printEventBenefitPreview() {
        printMessage(EVENT_BENEFIT_PREVIEW);
        println();
    }

    public void printOrderedMenu(final OrderDto orderDto) {
        printMessage(ORDERED_MENU_PREFIX);
        println(orderDto.toString());
    }

    public void printPreDiscountAmount(final PreDiscountAmountDto preDiscountAmountDto) {
        printMessage(PRE_DISCOUNT_AMOUNT_PREFIX);
        println(preDiscountAmountDto.toString());
    }

    public void printGiveaway(final GiveawayMenuDto giveawayMenuDto) {
        printMessage(GIVEAWAY_PREFIX);
        println(giveawayMenuDto.toString());
    }

    public void printBenefits(final BenefitsDto benefitsDto) {
        printMessage(BENEFIT_PREFIX);
        println(benefitsDto.toString());
    }

    public void printTotalBenefitAmount(final TotalBenefitAmountDto totalBenefitAmountDto) {
        printMessage(TOTAL_BENEFIT_AMOUNT_PREFIX);
        println(totalBenefitAmountDto.toString());
    }

    public void printPostDiscountAmount(final PostDiscountAmountDto postDiscountAmountDto) {
        printMessage(POST_DISCOUNT_AMOUNT_PREFIX);
        println(postDiscountAmountDto.toString());
    }

    public void printBadge(final EventBadgeDto eventBadgeDto) {
        printMessage(BADGE_PREFIX);
        println(eventBadgeDto.toString());
    }
}
