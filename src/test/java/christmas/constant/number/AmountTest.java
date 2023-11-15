package christmas.constant.number;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AmountTest extends UnitTest implements UnitTestStub {
    @Test
    @DisplayName("Amount에 숫자 더하기")
    void add() {
        assertThat(Amount.EVENT_CRITERIA.add(Amount.GIVEAWAY_CRITERIA.getValue()))
                .isEqualTo(ONE_HUNDRED_THIRTY_THOUSAND);
    }

    @Test
    @DisplayName("Amount에 숫자 곱하기")
    void multiply() {
        assertThat(Amount.EVENT_CRITERIA.multiply(Amount.GIVEAWAY_CRITERIA.getValue()))
                .isEqualTo(ONE_POINT_TWO_BILLION);
    }

    @Test
    @DisplayName("Amount 값 가져오기")
    void getValue() {
        assertThat(Amount.EVENT_CRITERIA.getValue())
                .isEqualTo(TEN_THOUSAND);
    }
}