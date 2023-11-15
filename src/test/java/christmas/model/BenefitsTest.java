package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BenefitsTest extends UnitTest implements UnitTestStub {
    @BeforeEach
    void setUp() {
        benefits = Benefits.from(VISIT_DATE, ORDER);
    }

    @Test
    @DisplayName("Benefits 객체 생성")
    void from() {
        assertThat(benefits)
                .isInstanceOf(Benefits.class);
    }

    @Test
    @DisplayName("Benefits 객체 생성2")
    void from2() {
        assertThat(Benefits.from(BENEFIT_AND_AMOUNT))
                .isInstanceOf(Benefits.class);
    }

    @Test
    @DisplayName("증정품이 있음")
    void hasGiveaway() {
        assertThat(benefits.hasGiveaway())
                .isTrue();
    }

    @Test
    @DisplayName("Giveaway 계산 후 반환")
    void calculateGiveawayMenu() {
        assertThat(benefits.calculateGiveawayMenu())
                .isEqualTo(GIVEAWAY_MENU);
    }

    @Test
    @DisplayName("TotalBenefitAmount 계산 후 반환")
    void calculateTotalBenefitAmount() {
        assertThat(benefits.calculateTotalBenefitAmount())
                .isEqualTo(TOTAL_BENEFIT_AMOUNT);
    }

    @Test
    @DisplayName("Giveaway 계산 후 반환")
    void benefits() {
        assertThat(benefits.hasGiveaway())
                .isTrue();
    }
}