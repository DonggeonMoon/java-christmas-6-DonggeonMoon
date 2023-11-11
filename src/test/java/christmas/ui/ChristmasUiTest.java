package christmas.ui;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

import christmas.constant.Message;
import christmas.constant.exception.ArgumentException;
import christmas.view.ChristmasInputView;
import christmas.view.ChristmasOutputView;
import java.util.NoSuchElementException;
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
    void readVisitDate(String input) {
        input(input);
        inputView.readVisitDate();

        assertThat(getOutput())
                .contains(Message.VISIT_DATE_INPUT_PROMPT.getText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "31"})
    void readVisitDate2(String input) {
        input(input);
        int integer = inputView.readVisitDate();

        assertThat(integer).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {",", "  "})
    void readVisitDate3(String input) throws NoSuchElementException {
        input(input);

        assertThatThrownBy(() -> inputView.readVisitDate())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ArgumentException.INVALID_DATE.exception().getMessage());
    }
}
