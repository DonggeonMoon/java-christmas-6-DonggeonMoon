package christmas.constant.calendar;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PeriodTest extends UnitTest implements UnitTestStub {
    @ParameterizedTest
    @DisplayName("숫자로 날짜 생성")
    @CsvSource({"2023, 12, 15"})
    void generateDateFrom(int year, int month, int day) {
        assertThat(Period.CHRISTMAS_D_DAY_EVENT.generateDateFrom(day))
                .isEqualTo(LocalDate.of(year, month, day));
    }

    @ParameterizedTest
    @DisplayName("기간이 날짜를 포함하지 않는지 검증")
    @ValueSource(ints = {-1, 0, 32, 33})
    void notIncludes(int day) {
        assertThat(Period.CHRISTMAS_D_DAY_EVENT.notIncludes(day))
                .isTrue();
    }

    @ParameterizedTest
    @DisplayName("기간이 날짜를 포함하는지 검증")
    @ValueSource(ints = {30, 31})
    void notIncludes2(int day) {
        assertThat(Period.CHRISTMAS_D_DAY_EVENT.notIncludes(day))
                .isTrue();
    }
}