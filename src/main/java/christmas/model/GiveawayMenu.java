package christmas.model;

import static christmas.constant.number.Count.ONE;

import christmas.constant.menu.MenuCategory.Menu;
import java.util.EnumMap;
import java.util.Objects;

public record GiveawayMenu(
        EnumMap<Menu, Integer> menuAndCount
) {
    public static GiveawayMenu from(final Benefits benefits) {
        Objects.requireNonNull(benefits);

        EnumMap<Menu, Integer> menuAndCounts = new EnumMap<>(Menu.class);
        if (benefits.hasGiveaway()) {
            menuAndCounts.put(Menu.CHAMPAGNE, ONE.getValue());
            return new GiveawayMenu(menuAndCounts);
        }
        return new GiveawayMenu(menuAndCounts);
    }
}
