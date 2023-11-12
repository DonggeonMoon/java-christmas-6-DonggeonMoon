package christmas.dto;

import christmas.constant.menu.MenuCategory.Menu;
import christmas.model.OrderedMenu;
import java.util.Map;

public record OrderedMenuDto(Map<Menu, Integer> menuAndCount) {
    public static OrderedMenuDto from(OrderedMenu orderedMenu) {
        return new OrderedMenuDto(orderedMenu.getMenuAndCount());
    }
}
