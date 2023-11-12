package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.menu.MenuCategory.Menu;
import java.time.LocalDate;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PostDiscountAmountTest {
    private VisitDate visitDate;
    private OrderedMenu orderedMenu;
    private Map<Menu, Integer> menuAndCount;
    private Benefits benefits;
    private PreDiscountAmount preDiscountAmount;
    private TotalBenefitAmount totalBenefitAmount;
    private PostDiscountAmount postDiscountAmount;

    @BeforeEach
    void setUp() {
        visitDate = VisitDate.from(LocalDate.of(2023, 12, 3));
        menuAndCount = Map.of(Menu.SEAFOOD_PASTA, 2, Menu.RED_WINE, 1, Menu.CHOCOLATE_CAKE, 1);
        orderedMenu = OrderedMenu.from(menuAndCount);
        benefits = Benefits.from(visitDate, orderedMenu);
        preDiscountAmount = PreDiscountAmount.from(orderedMenu);
        totalBenefitAmount = TotalBenefitAmount.from(benefits);
        postDiscountAmount = PostDiscountAmount.of(preDiscountAmount, totalBenefitAmount);
    }
    @Test
    void of() {
        assertThat(postDiscountAmount)
                .isInstanceOf(PostDiscountAmount.class);
    }
}