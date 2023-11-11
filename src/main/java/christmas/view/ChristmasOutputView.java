package christmas.view;

import static christmas.constant.Message.EVENT_PLANNER;

public class ChristmasOutputView extends AbstractView {
    private ChristmasOutputView() {
    }

    public static ChristmasOutputView create() {
        return new ChristmasOutputView();
    }

    public void printEventPlannerMessage() {
        printMessage(EVENT_PLANNER);
    }
}
