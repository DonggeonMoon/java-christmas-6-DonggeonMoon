package christmas.dto;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PostDiscountAmountDtoTest extends UnitTest implements UnitTestStub {
    @BeforeEach
    void setUp() {
        postDiscountAmountDto = PostDiscountAmountDto.from(POST_DISCOUNT_AMOUNT);
    }

    @Test
    @DisplayName("PostDiscountAmountDto 객체 생성")
    void from() {
        assertThat(postDiscountAmountDto)
                .isInstanceOf(PostDiscountAmountDto.class);
    }

    @Test
    @DisplayName("출력 메시지 생성")
    void testToString() {
        assertThat(postDiscountAmountDto.toString())
                .contains(POST_DISCOUNT_AMOUNT_DTO_MESSAGE);
    }
}