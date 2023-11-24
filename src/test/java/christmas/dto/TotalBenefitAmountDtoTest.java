package christmas.dto;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.TotalBenefitAmount;
import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalBenefitAmountDtoTest extends UnitTest implements UnitTestStub {
    @BeforeEach
    void setUp() {
        totalBenefitAmountDto = TotalBenefitAmountDto.from(TOTAL_BENEFIT_AMOUNT);
    }

    @Test
    @DisplayName("TotalBenefitAmountDto 객체 생성")
    void from() {
        assertThat(totalBenefitAmountDto)
                .isInstanceOf(TotalBenefitAmountDto.class);
    }

    @Test
    @DisplayName("모델로 변환")
    void toModel() {
        assertThat(totalBenefitAmountDto.toModel())
                .isInstanceOf(TotalBenefitAmount.class);
    }

    @Test
    @DisplayName("출력 메시지 생성")
    void testToString() {
        assertThat(totalBenefitAmountDto.toString())
                .contains(TOTAL_BENEFIT_AMOUNT_DTO_MESSAGE);
    }

    @Test
    @DisplayName("EventBadge 계산 후 반환")
    void calculateEventBadgeDto() {
        assertThat(totalBenefitAmountDto.calculateEventBadgeDto())
                .isEqualTo(EVENT_BADGE_DTO);
    }
}