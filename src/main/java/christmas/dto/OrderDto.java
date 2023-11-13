package christmas.dto;

import christmas.constant.menu.MenuCategory.Menu;
import christmas.model.Order;
import java.util.Map;

public record OrderDto(Map<Menu, Integer> menuAndCount) {
    public static OrderDto from(final Order order) {
        return new OrderDto(order.menuAndCount());
    }

    public Order toEntity() {
        return Order.from(
                this.menuAndCount
        );
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        menuAndCount.forEach(((menu, count) -> {
            stringBuilder.append(menu.getName());
            stringBuilder.append(" ");
            stringBuilder.append(count);
            stringBuilder.append("개");
            stringBuilder.append("\n");
        }));
        return stringBuilder.toString();
    }
}
