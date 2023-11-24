package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.constant.exception.ArgumentException;
import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class VisitDateTest extends UnitTest implements UnitTestStub {
    @BeforeEach
    void setUp() {
        visitDate = VisitDate.from(WEEKEND_DATE);
    }

    @Test
    @DisplayName("VisitDate 객체 생성")
    void from() {
        assertThat(visitDate)
                .isInstanceOf(VisitDate.class);
    }

    @ParameterizedTest
    @DisplayName("VisitDate 객체 생성")
    @ValueSource(ints = {1, 15, 31})
    void from2(int inputDay) {
        visitDate = VisitDate.from(inputDay);

        assertThat(visitDate)
                .isInstanceOf(VisitDate.class);
    }

    @ParameterizedTest
    @DisplayName("날짜가 범위를 벗어나 VisitDate 객체 생성 실패")
    @ValueSource(ints = {-1, 0, 32, 45})
    void from3(int inputDay) {
        assertThatThrownBy(() -> VisitDate.from(inputDay)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ArgumentException.INVALID_DATE.exception().getMessage());
    }

    @Test
    @DisplayName("일자 계산 후 반환")
    void calculateDayOfMonth() {
        assertThat(visitDate.calculateDayOfMonth())
                .isEqualTo(EXPECTED_DAY_OF_MONTH);
    }

    @Test
    @DisplayName("일자 계산 후 BigDecimal 타입으로 반환")
    void calculateDayOfMonthInBigDecimal() {
        assertThat(visitDate.calculateDayOfMonthInBigDecimal())
                .isEqualTo(EXPECTED_DAY_OF_MONTH_IN_BIGDECIMAL);
    }

    @Test
    @DisplayName("평일이 아님")
    void isWeekDay() {
        assertThat(visitDate.isWeekDay())
                .isFalse();
    }

    @Test
    @DisplayName("평일임")
    void isWeekend() {
        assertThat(visitDate.isWeekend())
                .isTrue();
    }

    @Test
    @DisplayName("주말이 아님")
    void isWeekDay2() {
        visitDate = VisitDate.from(WEEKDAY_AND_STARRED_DATE);
        assertThat(visitDate.isWeekDay())
                .isTrue();
    }

    @Test
    @DisplayName("주말임")
    void isWeekend2() {
        visitDate = VisitDate.from(WEEKDAY_AND_STARRED_DATE);
        assertThat(visitDate.isWeekend())
                .isFalse();
    }

    @Test
    @DisplayName("별이 표시된 일자가 아님")
    void isNotStarredDate() {
        visitDate = VisitDate.from(WEEKDAY_AND_STARRED_DATE);
        assertThat(visitDate.isNotStarredDate())
                .isFalse();
    }
}