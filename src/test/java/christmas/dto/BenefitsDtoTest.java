package christmas.dto;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.Benefits;
import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BenefitsDtoTest extends UnitTest implements UnitTestStub {
    @BeforeEach
    void setUp() {
        benefitsDto = BenefitsDto.from(BENEFITS);
    }

    @Test
    @DisplayName("BenefitDto 객체 생성")
    void from() {
        assertThat(benefitsDto)
                .isInstanceOf(BenefitsDto.class);
    }

    @Test
    @DisplayName("혜택 없는 BenefitDto 객체 생성")
    void withoutAnyBenefit() {
        assertThat(BenefitsDto.withoutAnyBenefit())
                .isEqualTo(EMPTY_BENEFIT_DTO);
    }

    @Test
    @DisplayName("모델로 변환")
    void toModel() {
        assertThat(benefitsDto.toModel())
                .isInstanceOf(Benefits.class);
    }

    @Test
    @DisplayName("출력 메시지 생성")
    void testToString() {
        assertThat(benefitsDto.toString())
                .contains(BENEFITS_DTO_MESSAGE);
    }

    @Test
    @DisplayName("GiveAwayMenuDto 계산 후 반환")
    void calculateGiveawayMenuDto() {
        assertThat(benefitsDto.calculateGiveawayMenuDto())
                .isEqualTo(GIVEAWAY_MENU_DTO);
    }

    @Test
    @DisplayName("BenefitAmountDto 계산 후 반환")
    void calculateTotalBenefitAmountDto() {
        assertThat(benefitsDto.calculateTotalBenefitAmountDto())
                .isEqualTo(TOTAL_BENEFIT_AMOUNT_DTO);
    }
}