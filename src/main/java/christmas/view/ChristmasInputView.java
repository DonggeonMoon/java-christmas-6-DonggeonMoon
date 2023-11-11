package christmas.view;

import static christmas.constant.Message.VISIT_DATE_INPUT_PROMPT;

import camp.nextstep.edu.missionutils.Console;

public class ChristmasInputView extends AbstractView {
    private ChristmasInputView() {
    }

    public static ChristmasInputView create() {
        return new ChristmasInputView();
    }

    public String askVisitDate() {
        printMessage(VISIT_DATE_INPUT_PROMPT);
        return Console.readLine();
    }
}
