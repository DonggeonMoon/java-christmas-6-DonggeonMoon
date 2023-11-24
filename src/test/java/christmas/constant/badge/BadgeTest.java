package christmas.constant.badge;


import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.Benefits;
import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

class BadgeTest extends UnitTest implements UnitTestStub {
    @ParameterizedTest
    @DisplayName("Badge 객체 생성")
    @EnumSource(Badge.class)
    void from(Badge badge) {
        benefits = Benefits.from(BENEFIT_AND_AMOUNT);
        totalBenefitAmount = benefits.calculateTotalBenefitAmount();

        assertThat(badge)
                .isInstanceOf(Badge.class);
    }

    @ParameterizedTest
    @DisplayName("Badge 객체 생성")
    @EnumSource(Badge.class)
    void from2(Badge badge) {
        benefits = Benefits.from(BENEFIT_AND_AMOUNT2);
        totalBenefitAmount = benefits.calculateTotalBenefitAmount();

        assertThat(badge)
                .isInstanceOf(Badge.class);
    }

    @ParameterizedTest
    @DisplayName("Badge 이름 가져오기")
    @CsvSource({"NONE, 없음", "STAR, 별", "TREE, 트리", "SANTA, 산타"})
    void getName(Badge badge, String name) {
        assertThat(badge.getName())
                .isEqualTo(name);
    }
}