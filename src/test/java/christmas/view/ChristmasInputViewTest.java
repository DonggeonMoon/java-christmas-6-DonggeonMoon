package christmas.view;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristmasInputViewTest extends UnitTest implements UnitTestStub {
    @Test
    @DisplayName("ChristmasInputView 객체 생성")
    void create() {
        inputView = ChristmasInputView.create();

        assertThat(inputView)
                .isInstanceOf(ChristmasInputView.class);
    }
}