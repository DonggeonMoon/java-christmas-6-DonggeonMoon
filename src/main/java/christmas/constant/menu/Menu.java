package christmas.constant.menu;

import static christmas.constant.exception.ArgumentException.INVALID_ORDER;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

public enum Menu {
    MUSHROOM_SOUP("양송이수프", MenuCategory.APPETIZER, BigDecimal.valueOf(6000)),
    TAPAS("타파스", MenuCategory.APPETIZER, BigDecimal.valueOf(5500)),
    CAESAR_SALAD("시저 샐러드", MenuCategory.APPETIZER, BigDecimal.valueOf(8000)),
    T_BONE_STEAK("티본스테이크", MenuCategory.MAIN_MENU, BigDecimal.valueOf(55000)),
    BARBEQUE_RIB("바비큐립", MenuCategory.MAIN_MENU, BigDecimal.valueOf(54000)),
    SEAFOOD_PASTA("해산물파스타", MenuCategory.MAIN_MENU, BigDecimal.valueOf(35000)),
    CHRISTMAS_PASTA("크리스마스파스타", MenuCategory.MAIN_MENU, BigDecimal.valueOf(25000)),
    CHOCOLATE_CAKE("초코케이크", MenuCategory.DESSERT, BigDecimal.valueOf(15000)),
    ICE_CREAM("아이스크림", MenuCategory.DESSERT, BigDecimal.valueOf(5000)),
    ZERO_COKE("제로콜라", MenuCategory.DRINK, BigDecimal.valueOf(3000)),
    RED_WINE("레드와인", MenuCategory.DRINK, BigDecimal.valueOf(60000)),
    CHAMPAGNE("샴페인", MenuCategory.DRINK, BigDecimal.valueOf(25000)),
    NOTHING("없음", MenuCategory.NONE, BigDecimal.ZERO);

    private final String name;
    private final MenuCategory category;
    private final BigDecimal price;

    Menu(
            final String name,
            final MenuCategory category,
            final BigDecimal price
    ) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public static Menu from(final String menuName) {
        Objects.requireNonNull(menuName);

        return Arrays.stream(values())
                .filter(menu -> menu.name.equals(menuName))
                .findFirst()
                .orElseThrow(INVALID_ORDER::exception);
    }

    public boolean isMainMenu() {
        return this.category == MenuCategory.MAIN_MENU;
    }

    public boolean isDessert() {
        return this.category == MenuCategory.DESSERT;
    }

    public boolean isNotDrink() {
        return this.category != MenuCategory.DRINK;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    enum MenuCategory {
        APPETIZER,
        MAIN_MENU,
        DESSERT,
        DRINK,
        NONE
    }
}
