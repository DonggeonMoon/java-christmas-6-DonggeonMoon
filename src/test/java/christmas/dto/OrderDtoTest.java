package christmas.dto;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderDtoTest extends UnitTest implements UnitTestStub {
    @BeforeEach
    void setUp() {
        orderDto = OrderDto.from(ORDER);
    }

    @Test
    @DisplayName("OrderDto 객체 생성")
    void from() {
        assertThat(orderDto)
                .isInstanceOf(OrderDto.class);
    }

    @Test
    @DisplayName("OrderDto 객체 생성")
    void from2() {
        assertThat(OrderDto.from(VALID_INPUT))
                .isEqualTo(ORDER_DTO);
    }

    @Test
    @DisplayName("출력 메시지 생성")
    void testToString() {
        assertThat(orderDto.toString())
                .contains(ORDER_DTO_MESSAGE);
    }

    @Test
    @DisplayName("PreDiscountAmountDto 계산 후 반환")
    void calculatePreDiscountAmountDto() {
        assertThat(orderDto.toString())
                .contains(ORDER_DTO_MESSAGE);

    }

    @Test
    @DisplayName("BenefitsDto 계산 후 반환")
    void calculateBenefitsDtoFrom() {
        assertThat(orderDto.calculateBenefitsDtoFrom(VISIT_DATE_DTO, PRE_DISCOUNT_AMOUNT_DTO))
                .isEqualTo(BENEFITS_DTO);
    }
}