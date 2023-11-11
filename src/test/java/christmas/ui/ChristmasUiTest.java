package christmas.ui;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.Message;
import christmas.view.ChristmasOutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChristmasUiTest extends UiTest {
    private ChristmasOutputView outputView;

    @BeforeEach
    void setUp() {
        outputView = ChristmasOutputView.create();
    }

    @Test
    void printEventPlannerMessage() {
        outputView.printEventPlannerMessage();

        assertThat(getOutput())
                .contains(Message.EVENT_PLANNER.getText());
    }
}
