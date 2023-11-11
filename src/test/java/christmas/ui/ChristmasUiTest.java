package christmas.ui;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.Message;
import christmas.view.ChristmasInputView;
import christmas.view.ChristmasOutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ChristmasUiTest extends UiTest {
    private ChristmasOutputView outputView;
    private ChristmasInputView inputView;

    @BeforeEach
    void setUp() {
        outputView = ChristmasOutputView.create();
        inputView = ChristmasInputView.create();
    }

    @Test
    void printEventPlannerMessage() {
        outputView.printEventPlannerMessage();

        assertThat(getOutput())
                .contains(Message.EVENT_PLANNER.getText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "31"})
    void askVisitDate(String input) {
        input(input);
        inputView.askVisitDate();

        assertThat(getOutput())
                .contains(Message.VISIT_DATE_INPUT_PROMPT.getText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "31"})
    void askVisitDate2(String input) {
        input(input);
        String string = inputView.askVisitDate();

        assertThat(string).contains(input);
    }
}
