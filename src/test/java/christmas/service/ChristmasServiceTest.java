package christmas.service;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.menu.MenuCategory.Menu;
import christmas.dto.OrderedMenuDto;
import christmas.dto.PreDiscountAmountDto;
import christmas.dto.VisitDateDto;
import christmas.model.OrderedMenu;
import christmas.model.PreDiscountAmount;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ChristmasServiceTest {
    private ChristmasService service;
    private Map<Menu, Integer> menuAndCount;
    private OrderedMenu orderedMenu;
    private OrderedMenuDto orderedMenuDto;
    private PreDiscountAmount preDiscountAmount;
    private PreDiscountAmountDto preDiscountAmountDto;

    @BeforeEach
    void setUp() {
        service = ChristmasService.create();
        menuAndCount = Map.of(Menu.SEAFOOD_PASTA, 2, Menu.RED_WINE, 1, Menu.CHOCOLATE_CAKE, 1);
        orderedMenu = OrderedMenu.from(menuAndCount);
        orderedMenuDto = OrderedMenuDto.from(orderedMenu);
        preDiscountAmount = PreDiscountAmount.from(orderedMenu);
        preDiscountAmountDto = PreDiscountAmountDto.from(preDiscountAmount);
    }

    @Test
    void create() {
        assertThat(service)
                .isInstanceOf(ChristmasService.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 31})
    void generateVisitDate(int inputDay) {
        assertThat(service.generateVisitDate(inputDay))
                .isInstanceOf(VisitDateDto.class);
    }

    @Test
    void generatePreDiscountAmount() {
        assertThat(service.generatePreDiscountAmount(orderedMenuDto))
                .isInstanceOf(PreDiscountAmountDto.class);

    }
}