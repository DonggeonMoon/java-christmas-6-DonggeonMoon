package christmas.view;

import static christmas.constant.Message.EVENT_PLANNER;

import christmas.controller.ChristmasController;

public class ChristmasOutputView implements View {
    private ChristmasOutputView() {
    }

    public static ChristmasOutputView create() {
        return new ChristmasOutputView();
    }

    public void printEventPlannerMessage() {
        printMessage(EVENT_PLANNER);
    }
}
