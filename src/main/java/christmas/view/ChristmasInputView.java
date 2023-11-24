package christmas.view;

import static christmas.constant.string.Message.MENU_AND_COUNT_INPUT_PROMPT;
import static christmas.constant.string.Message.VISIT_DATE_INPUT_PROMPT;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.validation.StringValidation;

public class ChristmasInputView extends AbstractView {
    private ChristmasInputView() {
    }

    public static ChristmasInputView create() {
        return new ChristmasInputView();
    }

    public int readVisitDate() {
        printMessage(VISIT_DATE_INPUT_PROMPT);
        String input = Console.readLine();
        StringValidation.NOT_EMPTY_RULE.validate(input);
        StringValidation.NUMBER_RULE.validate(input);
        return Integer.parseInt(input);
    }

    public String readMenuAndCount() {
        printMessage(MENU_AND_COUNT_INPUT_PROMPT);
        return Console.readLine();
    }
}
