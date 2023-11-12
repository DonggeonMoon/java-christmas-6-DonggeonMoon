package christmas.constant.menu;

import static christmas.constant.exception.ArgumentException.INVALID_MENU;

import java.math.BigDecimal;
import java.util.Arrays;

public enum MenuCategory {
    APPETIZER,
    MAIN_MENU,
    DESSERT,
    DRINK;

    public enum Menu {
        MUSHROOM_SOUP("양송이수프", APPETIZER, BigDecimal.valueOf(6000)),
        TAPAS("타파스", APPETIZER, BigDecimal.valueOf(5500)),
        CAESAR_SALAD("시저 샐러드", APPETIZER, BigDecimal.valueOf(8000)),
        T_BONE_STEAK("티본스테이크", MAIN_MENU, BigDecimal.valueOf(55000)),
        BARBEQUE_RIP("바비큐립", MAIN_MENU, BigDecimal.valueOf(54000)),
        SEAFOOD_PASTA("해산물파스타", MAIN_MENU, BigDecimal.valueOf(35000)),
        CHRISTMAS_PASTA("크리스마스파스타", MAIN_MENU, BigDecimal.valueOf(25000)),
        CHOCOLATE_CAKE("초코케이크", DESSERT, BigDecimal.valueOf(15000)),
        ICE_CREAM("아이스크림", DESSERT, BigDecimal.valueOf(5000)),
        ZERO_COKE("제로콜라", DRINK, BigDecimal.valueOf(3000)),
        RED_WINE("레드와인", DRINK, BigDecimal.valueOf(60000)),
        CHAMPAGNE("샴페인", DRINK, BigDecimal.valueOf(25000));

        private final String name;
        private final MenuCategory category;
        private final BigDecimal price;

        Menu(final String name, final MenuCategory category, final BigDecimal price) {
            this.name = name;
            this.category = category;
            this.price = price;
        }

        public static Menu from(String input) {
            return Arrays.stream(values())
                    .filter(menu -> menu.name.equals(input))
                    .findFirst()
                    .orElseThrow(INVALID_MENU::exception);
        }

        public boolean isNotDrink() {
            return this.category != MenuCategory.DRINK;
        }

        public String getName() {
            return name;
        }
    }
}
