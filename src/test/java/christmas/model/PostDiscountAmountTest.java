package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PostDiscountAmountTest extends UnitTest implements UnitTestStub {
    @BeforeEach
    void setUp() {
        postDiscountAmount = PostDiscountAmount.of(PRE_DISCOUNT_AMOUNT, TOTAL_BENEFIT_AMOUNT);
    }

    @Test
    @DisplayName("PostDiscountAmount 객체 생성")
    void of() {
        assertThat(postDiscountAmount)
                .isInstanceOf(PostDiscountAmount.class);
    }

    @Test
    @DisplayName("PostDiscountAmount 객체 생성2")
    void from() {
        assertThat(PostDiscountAmount.from(THOUSAND))
                .isInstanceOf(PostDiscountAmount.class);
    }
}