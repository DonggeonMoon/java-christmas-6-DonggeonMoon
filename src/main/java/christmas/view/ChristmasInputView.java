package christmas.view;

import static christmas.constant.Message.VISIT_DATE_INPUT_PROMPT;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.validation.Validation;

public class ChristmasInputView extends AbstractView {
    private ChristmasInputView() {
    }

    public static ChristmasInputView create() {
        return new ChristmasInputView();
    }

    public int readVisitDate() {
        printMessage(VISIT_DATE_INPUT_PROMPT);
        String input = Console.readLine();
        Validation.NOT_EMPTY_RULE.validate(input);
        Validation.NUMBER_RULE.validate(input);

        return Integer.parseInt(input);
    }
}
