package christmas.model;

import static christmas.constant.Delimiter.COMMA;
import static christmas.constant.Delimiter.DASH;
import static christmas.constant.exception.ArgumentException.INVALID_MENU;

import christmas.constant.exception.ArgumentException;
import christmas.constant.menu.MenuCategory.Menu;
import christmas.constant.validation.IntegerValidation;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrderedMenu {
    private final Map<Menu, Integer> menuAndCount;

    private OrderedMenu(final Map<Menu, Integer> menuAndCount) {
        this.menuAndCount = menuAndCount;
    }

    public static OrderedMenu from(Map<Menu, Integer> menuAndCount) {
        return new OrderedMenu(menuAndCount);
    }

    public static OrderedMenu from(final String inputMenuAndCount) {
        Objects.requireNonNull(inputMenuAndCount);
        List<List<String>> list = COMMA.split(inputMenuAndCount)
                .stream()
                .map(DASH::split)
                .toList();

        validate(list);

        Map<Menu, Integer> menuAndCount = list.stream()
                .collect(Collectors.toUnmodifiableMap(
                        menu -> Menu.from(menu.get(0)),
                        count -> Integer.parseInt(count.get(1))
                ));

        return new OrderedMenu(menuAndCount);
    }

    private static void validate(final List<List<String>> list) {
        try {
            List<String> menus = list.stream()
                    .map(menuAndCount -> menuAndCount.get(0))
                    .toList();

            List<Integer> counts = list.stream()
                    .map(menuAndCount -> menuAndCount.get(1))
                    .map(Integer::parseInt)
                    .toList();
            validateMenus(menus);
            validateCounts(counts);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw INVALID_MENU.exception();
        }
    }

    private static void validateMenus(final List<String> menus) {
        validateOnlyDrink(menus);
        validateDuplicated(menus);
    }

    private static void validateOnlyDrink(final List<String> menus) {
        if (onlyDrink(menus)) {
            throw INVALID_MENU.exception();
        }
    }

    private static boolean onlyDrink(final List<String> menus) {
        return menus.stream()
                .map(Menu::from)
                .noneMatch(Menu::isNotDrink);
    }

    private static void validateDuplicated(final List<String> menus) {
        if (duplicated(menus)) {
            throw INVALID_MENU.exception();
        }
    }

    private static boolean duplicated(final List<String> pairs) {
        return pairs.stream()
                .distinct()
                .count() != pairs.size();
    }


    private static void validateCounts(final List<Integer> counts) {
        validateLessThanOne(counts);
        validateMoreThanTwentyMenus(counts);
    }

    private static void validateMoreThanTwentyMenus(final List<Integer> counts) {
        if (moreThanTwenty(counts)) {
            throw ArgumentException.INVALID_MENU.exception();
        }
    }

    private static boolean moreThanTwenty(final List<Integer> counts) {
        return counts.stream()
                .mapToInt(Integer::intValue)
                .sum() > 20;
    }

    private static void validateLessThanOne(final List<Integer> counts) {
        counts.forEach(
                IntegerValidation.NOT_LESS_THAN_ONE::validate
        );
    }

    public Map<Menu, Integer> getMenuAndCount() {
        return menuAndCount;
    }
}