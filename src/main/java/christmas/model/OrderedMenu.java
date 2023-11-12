package christmas.model;

import static christmas.constant.Delimiter.COMMA;
import static christmas.constant.Delimiter.DASH;

import christmas.constant.menu.MenuCategory.Menu;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrderedMenu {
    private final Map<Menu, Integer> menuAndCount;

    private OrderedMenu(final Map<Menu, Integer> menuAndCount) {
        this.menuAndCount = menuAndCount;
    }

    public static OrderedMenu from(final String inputMenuAndCount) {
        Objects.requireNonNull(inputMenuAndCount);
        List<List<String>> list = COMMA.split(inputMenuAndCount)
                .stream()
                .map(DASH::split)
                .toList();

        Map<Menu, Integer> menuAndCount = list.stream()
                .collect(Collectors.toUnmodifiableMap(
                        menu -> Menu.from(menu.get(0)),
                        count -> Integer.parseInt(count.get(1))
                ));

        return new OrderedMenu(menuAndCount);
    }
}