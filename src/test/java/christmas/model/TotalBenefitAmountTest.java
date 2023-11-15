package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalBenefitAmountTest extends UnitTest implements UnitTestStub {
    @BeforeEach
    void setUp() {
        totalBenefitAmount = TOTAL_BENEFIT_AMOUNT;
    }

    @Test
    @DisplayName("TotalBenefitAmount 객체 생성")
    void from() {
        assertThat(totalBenefitAmount)
                .isInstanceOf(TotalBenefitAmount.class);
    }

    @Test
    @DisplayName("TotalBenefitAmount 객체 생성")
    void from2() {
        assertThat(totalBenefitAmount.amount())
                .isEqualTo(EXPECTED_TOTAL_BENEFIT_AMOUNT);
    }

    @Test
    @DisplayName("EventBadge 계산 후 반환")
    void calculateEventBadge() {
        assertThat(totalBenefitAmount.calculateEventBadge().badge().getName())
                .isEqualTo(EXPECTED_BADGE_NAME);
    }
}