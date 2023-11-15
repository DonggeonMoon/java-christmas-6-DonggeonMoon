package christmas.service;

import static christmas.constant.exception.ArgumentException.INVALID_DATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.dto.BenefitsDto;
import christmas.dto.EventBadgeDto;
import christmas.dto.GiveawayMenuDto;
import christmas.dto.OrderDto;
import christmas.dto.PostDiscountAmountDto;
import christmas.dto.PreDiscountAmountDto;
import christmas.dto.TotalBenefitAmountDto;
import christmas.dto.VisitDateDto;
import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ChristmasServiceTest extends UnitTest implements UnitTestStub {
    @BeforeEach
    void setUp() {
        service = ChristmasService.create();
    }

    @Test
    @DisplayName("ChristmasService 객체 생성")
    void create() {
        assertThat(service)
                .isInstanceOf(ChristmasService.class);
    }

    @ParameterizedTest
    @DisplayName("VisitDateDto 계산 후 생성")
    @ValueSource(ints = {1, 2, 31})
    void generateVisitDateFrom(int inputDay) {
        assertThat(service.generateVisitDateFrom(inputDay))
                .isInstanceOf(VisitDateDto.class);
    }

    @ParameterizedTest
    @DisplayName("VisitDateDto 계산 후 생성 실패")
    @ValueSource(ints = {-1, 0, 32})
    void generateVisitDateFrom2(int inputDay) {
        assertThatThrownBy(() -> service.generateVisitDateFrom(inputDay))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_DATE.exception().getMessage());
    }

    @Test
    @DisplayName("OrderDto 계산 후 생성")
    void generateOrderFrom() {
        assertThat(service.generateOrderFrom(VALID_INPUT))
                .isInstanceOf(OrderDto.class);
    }

    @Test
    @DisplayName("PreDiscountAmountDto 계산 후 생성")
    void generatePreDiscountAmountFrom() {
        assertThat(service.generatePreDiscountAmountFrom(ORDER_DTO))
                .isInstanceOf(PreDiscountAmountDto.class);
    }

    @Test
    @DisplayName("GiveawayMenuDto 계산 후 생성")
    void generateGiveAwayMenuFrom() {
        assertThat(service.generateGiveAwayMenuFrom(BENEFITS_DTO))
                .isInstanceOf(GiveawayMenuDto.class);
    }

    @Test
    @DisplayName("PostDiscountAmountDto 계산 후 생성")
    void generatePostDiscountAmount() {
        assertThat(service.generatePostDiscountAmount(PRE_DISCOUNT_AMOUNT_DTO, TOTAL_BENEFIT_AMOUNT_DTO))
                .isInstanceOf(PostDiscountAmountDto.class);
    }

    @Test
    @DisplayName("BenefitsDto 계산 후 생성")
    void generateBenefitsFrom() {
        assertThat(service.generateBenefitsFrom(VISIT_DATE_DTO, ORDER_DTO, PRE_DISCOUNT_AMOUNT_DTO))
                .isInstanceOf(BenefitsDto.class);
    }

    @Test
    @DisplayName("TotalBenefitAmountDto 계산 후 생성")
    void generateTotalBenefitFrom() {
        assertThat(service.generateTotalBenefitFrom(BENEFITS_DTO))
                .isInstanceOf(TotalBenefitAmountDto.class);
    }

    @Test
    @DisplayName("EventBadgeDto 계산 후 생성")
    void generateEventBadgeFrom() {
        assertThat(service.generateEventBadgeFrom(TOTAL_BENEFIT_AMOUNT_DTO))
                .isInstanceOf(EventBadgeDto.class);
    }
}