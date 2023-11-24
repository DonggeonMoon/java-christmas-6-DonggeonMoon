package christmas.constant.exception;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StateExceptionTest extends UnitTest implements UnitTestStub {
    @Test
    @DisplayName("StateException 예외 가져오기")
    void exception() {
        assertThat(StateException.INVALID_DATE.exception())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining(StateException.INVALID_DATE.getText());
    }
}