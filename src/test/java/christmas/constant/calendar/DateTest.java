package christmas.constant.calendar;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class DateTest extends UnitTest implements UnitTestStub {
    @ParameterizedTest
    @EnumSource(Date.class)
    void includes(Date date) {
        assertThat(date.includes(DECEMBER_THIRD))
                .isTrue();
    }

    @ParameterizedTest
    @EnumSource(Date.class)
    void includes2(Date date) {
        assertThat(date.includes(DECEMBER_FIFTH))
                .isFalse();
    }
}