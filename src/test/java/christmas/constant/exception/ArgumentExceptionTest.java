package christmas.constant.exception;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArgumentExceptionTest extends UnitTest implements UnitTestStub {
    @Test
    @DisplayName("ArgumentException 예외 가져오기")
    void exception() {
        assertThat(ArgumentException.INVALID_DATE.exception())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ArgumentException.INVALID_DATE.getText());
    }
}