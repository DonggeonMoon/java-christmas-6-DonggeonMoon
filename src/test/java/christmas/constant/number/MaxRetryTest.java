package christmas.constant.number;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MaxRetryTest extends UnitTest implements UnitTestStub {
    @ParameterizedTest
    @DisplayName("COUNT보다 입력된 횟수가 작음")
    @ValueSource(ints = 9)
    void isUnder(int count) {
        assertThat(MaxRetry.COUNT.isUnder(count))
                .isTrue();
    }

    @ParameterizedTest
    @DisplayName("COUNT보다 입력된 횟수가 작지 않음")
    @ValueSource(ints = 12)
    void isUnder2(int count) {
        assertThat(MaxRetry.COUNT.isUnder(count))
                .isFalse();
    }
}