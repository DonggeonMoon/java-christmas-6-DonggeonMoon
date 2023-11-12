package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.menu.MenuCategory.Menu;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderedMenuTest {
    private static String validInput = "해산물파스타-2,레드와인-1,초코케이크-1";
    private OrderedMenu orderedMenu;
    private Map<Menu, Integer> menuAndCount;

    @BeforeEach
    void setUp() {
        menuAndCount = Map.of(Menu.SEAFOOD_PASTA, 2, Menu.RED_WINE, 1, Menu.CHOCOLATE_CAKE, 1);
    }

    @Test
    void from() {
        orderedMenu = OrderedMenu.from(validInput);

        assertThat(orderedMenu)
                .isInstanceOf(OrderedMenu.class);

    }
}