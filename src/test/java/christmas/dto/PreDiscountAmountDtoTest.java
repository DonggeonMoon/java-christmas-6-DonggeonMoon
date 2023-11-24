package christmas.dto;

import static christmas.constant.number.Amount.EVENT_CRITERIA;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.PreDiscountAmount;
import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PreDiscountAmountDtoTest extends UnitTest implements UnitTestStub {
    @BeforeEach
    void setUp() {
        preDiscountAmountDto = PreDiscountAmountDto.from(PRE_DISCOUNT_AMOUNT);
    }

    @Test
    @DisplayName("PreDiscountAmountDto 객체 생성")
    void from() {
        assertThat(preDiscountAmountDto)
                .isInstanceOf(PreDiscountAmountDto.class);
    }

    @Test
    @DisplayName("모델로 변환")
    void toModel() {
        assertThat(preDiscountAmountDto.toModel())
                .isInstanceOf(PreDiscountAmount.class);
    }

    @Test
    @DisplayName("출력 메시지 생성")
    void testToString() {
        assertThat(preDiscountAmountDto.toString())
                .contains(PRE_DISCOUNT_AMOUNT_DTO_MESSAGE);
    }

    @Test
    @DisplayName("PostDiscountAmountDto 계산 후 반환")
    void calculatePostDiscountAmountDto() {
        assertThat(preDiscountAmountDto.calculatePostDiscountAmountDto(TOTAL_BENEFIT_AMOUNT_DTO))
                .isEqualTo(POST_DISCOUNT_AMOUNT_DTO);
    }

    @Test
    @DisplayName("PreDiscountAmountDto가 숫자보다 작지 않음")
    void isUnder() {
        assertThat(preDiscountAmountDto.isUnder(EVENT_CRITERIA))
                .isFalse();
    }
}