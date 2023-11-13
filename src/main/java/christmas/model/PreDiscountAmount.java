package christmas.model;

import christmas.constant.menu.MenuCategory.Menu;
import java.math.BigDecimal;
import java.util.Map.Entry;

public record PreDiscountAmount(
        BigDecimal amount
) {
    public static PreDiscountAmount from(final BigDecimal amount) {
        return new PreDiscountAmount(amount);
    }

    public static PreDiscountAmount from(final Order order) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (Entry<Menu, Integer> menuAndCount : order.menuAndCount().entrySet()) {
            BigDecimal menuPrice = menuAndCount.getKey().getPrice()
                    .multiply(BigDecimal.valueOf(menuAndCount.getValue()));
            totalAmount = totalAmount.add(menuPrice);

        }
        return new PreDiscountAmount(totalAmount);
    }

    public boolean isGreaterThan(final BigDecimal amount) {
        return this.amount.compareTo(amount) > 0;
    }

    public BigDecimal subtract(final TotalBenefitAmount totalBenefitAmount) {
        return amount.subtract(totalBenefitAmount.amount());
    }
}
