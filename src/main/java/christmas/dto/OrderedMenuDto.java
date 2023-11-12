package christmas.dto;

import christmas.constant.menu.MenuCategory.Menu;
import christmas.model.OrderedMenu;
import java.util.Map;

public record OrderedMenuDto(Map<Menu, Integer> menuAndCount) {
    public static OrderedMenuDto from(OrderedMenu orderedMenu) {
        return new OrderedMenuDto(orderedMenu.getMenuAndCount());
    }

    public OrderedMenu toEntity() {
        return OrderedMenu.from(
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
