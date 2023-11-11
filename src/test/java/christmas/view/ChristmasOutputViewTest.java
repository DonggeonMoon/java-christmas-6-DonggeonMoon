package christmas.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChristmasOutputViewTest {
    private ChristmasOutputView outputView;

    @BeforeEach
    void setUp() {
        outputView = ChristmasOutputView.create();
    }

    @Test
    void create() {
        assertThat(outputView).isInstanceOf(ChristmasOutputView.class);
    }
}