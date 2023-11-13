package christmas.service;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.menu.MenuCategory.Menu;
import christmas.dto.BenefitsDto;
import christmas.dto.OrderDto;
import christmas.dto.PreDiscountAmountDto;
import christmas.dto.TotalBenefitAmountDto;
import christmas.dto.VisitDateDto;
import christmas.model.Benefits;
import christmas.model.Order;
import christmas.model.PreDiscountAmount;
import christmas.model.TotalBenefitAmount;
import christmas.model.VisitDate;
import java.time.LocalDate;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ChristmasServiceTest {
    private ChristmasService service;
    private Map<Menu, Integer> menuAndCount;
    private Order order;
    private OrderDto orderDto;
    private PreDiscountAmount preDiscountAmount;
    private PreDiscountAmountDto preDiscountAmountDto;
    private VisitDate visitDate;
    private VisitDateDto visitDateDto;
    private Benefits benefits;
    private BenefitsDto benefitsDto;
    private TotalBenefitAmount totalBenefitAmount;
    private TotalBenefitAmountDto totalBenefitAmountDto;

    @BeforeEach
    void setUp() {
        visitDate = VisitDate.from(LocalDate.of(2023, 12, 3));
        visitDateDto = VisitDateDto.from(visitDate);
        service = ChristmasService.create();
        menuAndCount = Map.of(Menu.SEAFOOD_PASTA, 2, Menu.RED_WINE, 1, Menu.CHOCOLATE_CAKE, 1);
        order = Order.from(menuAndCount);
        orderDto = OrderDto.from(order);
        preDiscountAmount = PreDiscountAmount.from(order);
        preDiscountAmountDto = PreDiscountAmountDto.from(preDiscountAmount);
        benefits = Benefits.from(visitDate, order);
        benefitsDto = BenefitsDto.from(benefits);
        totalBenefitAmount = TotalBenefitAmount.from(benefits);
        totalBenefitAmountDto = TotalBenefitAmountDto.from(totalBenefitAmount);
    }

    @Test
    void create() {
        assertThat(service)
                .isInstanceOf(ChristmasService.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 31})
    void generateVisitDateFrom(int inputDay) {
        assertThat(service.generateVisitDateFrom(inputDay))
                .isInstanceOf(VisitDateDto.class);
    }
}