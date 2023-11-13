package christmas.model;

import static christmas.constant.exception.ArgumentException.INVALID_MENU;
import static christmas.constant.string.Delimiter.COMMA;
import static christmas.constant.string.Delimiter.DASH;

import christmas.constant.exception.ArgumentException;
import christmas.constant.menu.MenuCategory.Menu;
import christmas.constant.validation.IntegerValidation;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public record Order(
        Map<Menu, Integer> menuAndCount
) {
    public static Order from(final Map<Menu, Integer> menuAndCount) {
        Objects.requireNonNull(menuAndCount);

        return new Order(menuAndCount);
    }

    public static Order from(final String inputMenuAndCount) {
        Objects.requireNonNull(inputMenuAndCount);

        List<List<String>> list = splitInput(inputMenuAndCount);

        validate(list);

        Map<Menu, Integer> menuAndCount = calculateMenuAndCount(list);

        return new Order(menuAndCount);
    }

    private static List<List<String>> splitInput(final String inputMenuAndCount) {
        return COMMA.split(inputMenuAndCount)
                .stream()
                .map(DASH::split)
                .toList();
    }

    private static Map<Menu, Integer> calculateMenuAndCount(final List<List<String>> list) {
        return list.stream()
                .collect(Collectors.toUnmodifiableMap(
                        menu -> Menu.from(menu.get(0)),
                        count -> Integer.parseInt(count.get(1))
                ));
    }

    private static void validate(final List<List<String>> list) {
        try {
            List<String> menus = calculateMenus(list);

            List<Integer> counts = calculateCounts(list);
            validateMenus(menus);
            validateCounts(counts);
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw INVALID_MENU.exception();
        }
    }

    private static List<String> calculateMenus(final List<List<String>> list) {
        return list.stream()
                .map(menuAndCount -> menuAndCount.get(0))
                .toList();
    }

    private static List<Integer> calculateCounts(final List<List<String>> list) {
        return list.stream()
                .map(menuAndCount -> menuAndCount.get(1))
                .map(Integer::parseInt)
                .toList();
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

    public PreDiscountAmount calculatePreDiscountAmount() {
        return PreDiscountAmount.from(this);
    }
}