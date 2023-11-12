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
}
