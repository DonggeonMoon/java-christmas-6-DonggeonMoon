package christmas;

import christmas.controller.ChristmasController;
import christmas.view.ChristmasOutputView;

public class Application {
    public static void main(String[] args) {
        ChristmasController controller = ChristmasController.from(ChristmasOutputView.create());
        controller.start();
    }
}
