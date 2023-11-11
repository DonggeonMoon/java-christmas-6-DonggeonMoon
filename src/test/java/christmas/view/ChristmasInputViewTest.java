package christmas.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChristmasInputViewTest {
    private ChristmasInputView inputView;

    @BeforeEach
    void setUp() {
        inputView = ChristmasInputView.create();
    }

    @Test
    void create() {
        Assertions.assertThat(inputView)
                .isInstanceOf(ChristmasInputView.class);
    }
}