package christmas.dto;

import christmas.util.Formatter;
import christmas.constant.menu.MenuCategory.Menu;
import christmas.model.GiveawayMenu;
import java.util.EnumMap;
import java.util.Objects;

public record GiveawayMenuDto(
        EnumMap<Menu, Integer> menuAndCount
) {
    public static GiveawayMenuDto from(final GiveawayMenu giveawayMenu) {
        Objects.requireNonNull(giveawayMenu);

        return new GiveawayMenuDto(giveawayMenu.menuAndCount());
    }

    @Override
    public String toString() {
        return Formatter.formatGiveAway(menuAndCount);
    }
}
