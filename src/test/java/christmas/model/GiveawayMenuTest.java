package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.menu.Menu;
import java.time.LocalDate;
import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GiveawayMenuTest {
    public static final VisitDate VISIT_DATE = VisitDate.from(LocalDate.of(2023, 12, 3));
    public static final EnumMap<Menu, Integer> MENU_AND_COUNT = new EnumMap<>(
            Map.of(Menu.SEAFOOD_PASTA, 2, Menu.RED_WINE, 1, Menu.CHOCOLATE_CAKE, 1));
    private GiveawayMenu giveawayMenu;

    @BeforeEach
    void setUp() {
        Order order = Order.from(MENU_AND_COUNT);
        Benefits benefits = Benefits.from(VISIT_DATE, order);
        giveawayMenu = GiveawayMenu.from(benefits);
    }

    @Test
    void from() {
        assertThat(giveawayMenu)
                .isInstanceOf(GiveawayMenu.class);
    }
}