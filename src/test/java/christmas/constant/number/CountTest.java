package christmas.constant.number;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CountTest extends UnitTest implements UnitTestStub {
    @ParameterizedTest
    @DisplayName("Count 값 가져오기")
    @CsvSource({
            "ONE, 1",
            "MINIMUM_ORDER, 20"
    })
    void getValue(Count count, int value) {
        assertThat(count.getValue())
                .isEqualTo(value);
    }
}