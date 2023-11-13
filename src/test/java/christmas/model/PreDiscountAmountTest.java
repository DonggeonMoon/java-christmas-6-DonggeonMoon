package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.menu.Menu;
import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PreDiscountAmountTest {
    public static final EnumMap<Menu, Integer> MENU_AND_COUNT = new EnumMap<>(
            Map.of(Menu.SEAFOOD_PASTA, 2, Menu.RED_WINE, 1, Menu.CHOCOLATE_CAKE, 1));
    private PreDiscountAmount preDiscountAmount;

    @BeforeEach
    void setUp() {
        Order order = Order.from(MENU_AND_COUNT);
        preDiscountAmount = PreDiscountAmount.from(order);

    }

    @Test
    void from() {
        assertThat(preDiscountAmount)
                .isInstanceOf(PreDiscountAmount.class);
    }
}