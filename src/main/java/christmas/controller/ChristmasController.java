package christmas.controller;

import christmas.view.ChristmasInputView;
import christmas.view.ChristmasOutputView;

public class ChristmasController {
    private final ChristmasOutputView outputView;
    private final ChristmasInputView inputView;

    public ChristmasController(ChristmasOutputView outputView, ChristmasInputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public static ChristmasController from(final ChristmasOutputView outputView, final ChristmasInputView inputView) {
        return new ChristmasController(outputView, inputView);
    }

    public void start() {
        outputView.printEventPlannerMessage();
        inputView.askVisitDate();
    }
}
