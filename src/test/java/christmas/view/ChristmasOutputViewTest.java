package christmas.view;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristmasOutputViewTest extends UnitTest implements UnitTestStub {
    @Test
    @DisplayName("ChristmasOutputView 객체 생성")
    void create() {
        outputView = ChristmasOutputView.create();

        assertThat(outputView)
                .isInstanceOf(ChristmasOutputView.class);
    }
}