package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.menu.Menu;
import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PreDiscountAmountTest {
    private PreDiscountAmount preDiscountAmount;
    private Order order;
    private EnumMap<Menu, Integer> menuAndCount;

    @BeforeEach
    void setUp() {
        menuAndCount = new EnumMap<>(Map.of(Menu.SEAFOOD_PASTA, 2, Menu.RED_WINE, 1, Menu.CHOCOLATE_CAKE, 1));
        order = Order.from(menuAndCount);
        preDiscountAmount = PreDiscountAmount.from(order);

    }

    @Test
    void from() {
        assertThat(preDiscountAmount)
                .isInstanceOf(PreDiscountAmount.class);
    }
}