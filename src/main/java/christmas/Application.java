package christmas;

import christmas.controller.ChristmasController;
import christmas.view.ChristmasInputView;
import christmas.view.ChristmasOutputView;

public class Application {
    public static void main(String[] args) {
        ChristmasController controller = ChristmasController.from(
                ChristmasOutputView.create(),
                ChristmasInputView.create()
        );
        controller.start();
    }
}
