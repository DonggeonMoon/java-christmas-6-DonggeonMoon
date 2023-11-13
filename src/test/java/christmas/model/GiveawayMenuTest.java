package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.menu.MenuCategory.Menu;
import java.time.LocalDate;
import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GiveawayMenuTest {
    private VisitDate visitDate;
    private Order order;
    private EnumMap<Menu, Integer> menuAndCount;
    private Benefits benefits;
    private GiveawayMenu giveawayMenu;

    @BeforeEach
    void setUp() {
        visitDate = VisitDate.from(LocalDate.of(2023, 12, 3));
        menuAndCount = new EnumMap<>(Map.of(Menu.SEAFOOD_PASTA, 2, Menu.RED_WINE, 1, Menu.CHOCOLATE_CAKE, 1));
        order = Order.from(menuAndCount);
        benefits = Benefits.from(visitDate, order);
        giveawayMenu = GiveawayMenu.from(benefits);
    }

    @Test
    void from() {
        assertThat(giveawayMenu)
                .isInstanceOf(GiveawayMenu.class);
    }
}