package christmas.view;

import static christmas.constant.Message.VISIT_DATE_INPUT_PROMPT;

public class ChristmasInputView extends AbstractView {
    private ChristmasInputView() {
    }

    public static ChristmasInputView create() {
        return new ChristmasInputView();
    }

    public void askVisitDate() {
        printMessage(VISIT_DATE_INPUT_PROMPT);
    }
}
