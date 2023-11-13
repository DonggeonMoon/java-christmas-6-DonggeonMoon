package christmas.model;

import christmas.constant.menu.MenuCategory.Menu;
import java.time.LocalDate;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BenefitsTest {
    private VisitDate visitDate;
    private Order order;
    private Map<Menu, Integer> menuAndCount;
    private Benefits benefits;

    @BeforeEach
    void setUp() {
        visitDate = VisitDate.from(LocalDate.of(2023, 12, 3));
        menuAndCount = Map.of(Menu.SEAFOOD_PASTA, 2, Menu.RED_WINE, 1, Menu.CHOCOLATE_CAKE, 1);
        order = Order.from(menuAndCount);
        benefits = Benefits.from(visitDate, order);
    }

    @Test
    void from() {
        Assertions.assertThat(benefits)
                .isInstanceOf(Benefits.class);
    }
}