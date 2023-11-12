package christmas.view;

import static christmas.constant.Message.EVENT_BENEFIT_PREVIEW;
import static christmas.constant.Message.EVENT_PLANNER;
import static christmas.constant.Message.ORDERED_MENU_PREFIX;

import christmas.dto.OrderedMenuDto;

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
    }

    public void printOrderedMenu(OrderedMenuDto orderedMenuDto) {
        printMessage(ORDERED_MENU_PREFIX);
        println(orderedMenuDto.toString());
    }
}
