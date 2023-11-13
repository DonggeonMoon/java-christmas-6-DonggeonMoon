package christmas.model;

import christmas.constant.menu.MenuCategory.Menu;
import java.math.BigDecimal;
import java.util.Map.Entry;
import java.util.Objects;

public record PreDiscountAmount(
        BigDecimal amount
) {
    public static PreDiscountAmount from(final BigDecimal amount) {
        Objects.requireNonNull(amount);

        return new PreDiscountAmount(amount);
    }

    public static PreDiscountAmount from(final Order order) {
        Objects.requireNonNull(order);

        BigDecimal totalAmount = BigDecimal.ZERO;
        for (Entry<Menu, Integer> menuAndCount : order.menuAndCount().entrySet()) {
            BigDecimal menuPrice = menuAndCount.getKey().getPrice()
                    .multiply(BigDecimal.valueOf(menuAndCount.getValue()));
            totalAmount = totalAmount.add(menuPrice);

        }
        return new PreDiscountAmount(totalAmount);
    }

    public boolean isGreaterThan(final BigDecimal amount) {
        Objects.requireNonNull(amount);

        return this.amount.compareTo(amount) > 0;
    }

    public PostDiscountAmount subtract(final TotalBenefitAmount t) {
        Objects.requireNonNull(t);
        return PostDiscountAmount.from(this.amount.subtract(t.amount()));
    }
}
