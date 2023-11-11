package christmas.controller;

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
        run(() -> {
            inputView.readVisitDate();
            return null;
        });
    }
}
