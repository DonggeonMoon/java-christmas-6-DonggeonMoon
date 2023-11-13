package christmas;

import christmas.controller.ChristmasController;
import christmas.service.ChristmasService;
import christmas.view.ChristmasInputView;
import christmas.view.ChristmasOutputView;

public class Application {
    public static void main(String[] args) {
        try {
            ChristmasController controller = ChristmasController.from(
                    ChristmasOutputView.create(),
                    ChristmasInputView.create(),
                    ChristmasService.create()
            );
            controller.start();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
