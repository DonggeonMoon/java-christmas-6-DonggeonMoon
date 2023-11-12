package christmas.dto;

import christmas.constant.menu.MenuCategory.Menu;
import christmas.model.GiveawayMenu;
import java.util.EnumMap;

public record GiveawayMenuDto(
        EnumMap<Menu, Integer> menuAndCount
) {
    public static GiveawayMenuDto from(GiveawayMenu giveawayMenu) {
        return new GiveawayMenuDto(giveawayMenu.menuAndCount());
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
