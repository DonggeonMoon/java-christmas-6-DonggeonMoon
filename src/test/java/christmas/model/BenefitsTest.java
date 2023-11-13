package christmas.model;

import christmas.constant.menu.Menu;
import java.time.LocalDate;
import java.util.EnumMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BenefitsTest {
    private static final VisitDate visitDate = VisitDate.from(LocalDate.of(2023, 12, 3));
    private static final EnumMap<Menu, Integer> menuAndCount = new EnumMap<>(
            Map.of(Menu.SEAFOOD_PASTA, 2, Menu.RED_WINE, 1, Menu.CHOCOLATE_CAKE, 1));

    private Benefits benefits;

    @BeforeEach
    void setUp() {
        Order order = Order.from(menuAndCount);
        benefits = Benefits.from(visitDate, order);
    }

    @Test
    void from() {
        Assertions.assertThat(benefits)
                .isInstanceOf(Benefits.class);
    }
}