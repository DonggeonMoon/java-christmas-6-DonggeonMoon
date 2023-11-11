package christmas.controller;

import christmas.view.ChristmasOutputView;

public class ChristmasController {
    private final ChristmasOutputView outputView;

    private ChristmasController(final ChristmasOutputView outputView) {
        this.outputView = outputView;
    }

    public static ChristmasController from(final ChristmasOutputView outputView) {
        return new ChristmasController(outputView);
    }

    public void start() {
        // TODO: 컨트롤러 동작 로직 구현
    }
}
