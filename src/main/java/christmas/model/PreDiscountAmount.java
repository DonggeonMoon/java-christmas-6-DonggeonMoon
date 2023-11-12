package christmas.model;

import christmas.constant.menu.MenuCategory.Menu;
import java.math.BigDecimal;
import java.util.Map.Entry;

public record PreDiscountAmount(
        BigDecimal amount
) {
    public static PreDiscountAmount from(OrderedMenu orderedMenu) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (Entry<Menu, Integer> menuAndCount : orderedMenu.getMenuAndCount().entrySet()) {
            BigDecimal menuPrice = menuAndCount.getKey().getPrice()
                    .multiply(BigDecimal.valueOf(menuAndCount.getValue()));
            totalAmount = totalAmount.add(menuPrice);

        }
        return new PreDiscountAmount(totalAmount);
    }

    public boolean isGreaterThan(BigDecimal amount) {
        return this.amount.compareTo(amount) > 0;
    }
}
