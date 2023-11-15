package christmas.model;

import static christmas.constant.number.Amount.GIVEAWAY_CRITERIA;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PreDiscountAmountTest extends UnitTest implements UnitTestStub {
    @BeforeEach
    void setUp() {
        preDiscountAmount = PreDiscountAmount.from(ORDER);
    }

    @Test
    @DisplayName("PreDiscountAmount 객체 생성")
    void from() {
        assertThat(preDiscountAmount)
                .isInstanceOf(PreDiscountAmount.class);
    }

    @Test
    @DisplayName("PreDiscountAmount 객체 생성")
    void from2() {
        PreDiscountAmount preDiscountAmount = PreDiscountAmount.from(BigDecimal.ONE);
        assertThat(preDiscountAmount)
                .isInstanceOf(PreDiscountAmount.class);
    }

    @Test
    @DisplayName("preDiscountAmount가 입력한 금액보다 큼")
    void isGreaterThan() {
        assertThat(preDiscountAmount.isGreaterThan(GIVEAWAY_CRITERIA))
                .isTrue();
    }

    @Test
    @DisplayName("preDiscountAmount에 입력한 금액을 뺌")
    void subtract() {
        assertThat(preDiscountAmount.subtract(TOTAL_BENEFIT_AMOUNT))
                .isEqualTo(EXPECTED_POST_DISCOUNT_AMOUNT);
    }
}