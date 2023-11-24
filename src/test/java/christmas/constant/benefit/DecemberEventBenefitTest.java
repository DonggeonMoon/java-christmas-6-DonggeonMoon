package christmas.constant.benefit;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.Order;
import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DecemberEventBenefitTest extends UnitTest implements UnitTestStub {
    @Test
    @DisplayName("혜택 계산 1")
    void calculate() {
        assertThat(DecemberEventBenefit.calculate(VISIT_DATE_FROM_THREE, ORDER))
                .isEqualTo(BENEFIT_AND_AMOUNT3);
    }

    @Test
    @DisplayName("혜택 계산 2")
    void calculate2() {
        order = Order.from(MENU_AND_COUNT2);
        assertThat(DecemberEventBenefit.calculate(VISIT_DATE_FROM_EIGHT, ORDER2))
                .isEqualTo(BENEFIT_AND_AMOUNT4);
    }

    @Test()
    @DisplayName("혜택 계산 3")
    void calculate3() {
        order = Order.from(MENU_AND_COUNT2);
        assertThat(DecemberEventBenefit.calculate(VISIT_DATE_FROM_TWENTY_SIX, ORDER2))
                .isEqualTo(BENEFIT_AND_AMOUNT5);
    }

    @ParameterizedTest
    @DisplayName("DecemberEventBenefit 이름 가져오기")
    @CsvSource({
            "D_DAY_DISCOUNT, 크리스마스 디데이 할인",
            "WEEKDAY_DISCOUNT, 평일 할인",
            "WEEKEND_DISCOUNT, 주말 할인",
            "SPECIAL_DISCOUNT, 특별 할인",
            "GIVEAWAY, 증정 이벤트",
            "NOTHING, 없음"
    })
    void getName(DecemberEventBenefit decemberEventBenefit, String name) {
        assertThat(decemberEventBenefit.getName())
                .isEqualTo(name);
    }
}