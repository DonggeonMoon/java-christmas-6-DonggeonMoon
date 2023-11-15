package christmas.constant.calendar;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import java.time.DayOfWeek;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DayCategoryTest extends UnitTest implements UnitTestStub {
    @ParameterizedTest
    @DisplayName("기간이 해당 날짜를 포함하는지 검증")
    @CsvSource({"WEEKEND, FRIDAY"})
    void includes(DayCategory dayCategory, DayOfWeek dayOfWeek) {
        assertThat(dayCategory.includes(dayOfWeek))
                .isTrue();
    }

    @ParameterizedTest
    @DisplayName("기간이 해당 날짜를 포함하지 않는지 검증")
    @CsvSource({"WEEKDAYS, FRIDAY"})
    void includes2(DayCategory dayCategory, DayOfWeek dayOfWeek) {
        assertThat(dayCategory.includes(dayOfWeek))
                .isFalse();
    }
}