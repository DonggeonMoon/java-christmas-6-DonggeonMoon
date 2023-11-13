package christmas.util;

import christmas.constant.benefit.DecemberEventBenefit;
import christmas.constant.menu.MenuCategory.Menu;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.EnumMap;
import java.util.Map;

public class Formatter {
    private Formatter() {
    }

    public static String formatOrder(final Map<Menu, Integer> menuAndCount) {
        return formatQuantity(menuAndCount);
    }

    public static String formatGiveAway(final Map<Menu, Integer> menuAndCount) {
        if (menuAndCount.isEmpty()) {
            return Menu.NOTHING.getName() + Character.LINE_SEPARATOR.text;
        }

        return formatQuantity(menuAndCount);
    }

    private static String formatQuantity(final Map<Menu, Integer> menuAndCount) {
        StringBuilder stringBuilder = new StringBuilder();
        menuAndCount.forEach(((menu, count) -> {
            stringBuilder.append(menu.getName());
            stringBuilder.append(Character.SPACE.text);
            stringBuilder.append(count);
            stringBuilder.append(Character.EA.text);
            stringBuilder.append(Character.LINE_SEPARATOR.text);
        }));
        return stringBuilder.toString();
    }

    public static String formatBenefit(final EnumMap<DecemberEventBenefit, BigDecimal> benefits) {
        StringBuilder stringBuilder = new StringBuilder();
        if (benefits.isEmpty()) {
            stringBuilder.append(DecemberEventBenefit.NOTHING.getName());
            stringBuilder.append(Character.LINE_SEPARATOR);
            return stringBuilder.toString();
        }

        NumberFormat numberFormat = new DecimalFormat(MoneyFormat.MONEY_FORMAT.text);
        benefits.forEach((benefit, amount) -> {
            String formattedNumber = numberFormat.format(amount);
            stringBuilder.append(benefit.getName());
            stringBuilder.append(Character.SPACE.text);
            stringBuilder.append(formattedNumber);
            stringBuilder.append(Character.WON.text);
            stringBuilder.append(Character.LINE_SEPARATOR.text);
        });
        return stringBuilder.toString();
    }

    public static String formatAmount(final BigDecimal amount) {
        NumberFormat numberFormat = new DecimalFormat(MoneyFormat.MONEY_FORMAT.text);
        return numberFormat.format(amount)
                + Character.WON.text
                + Character.LINE_SEPARATOR.text;
    }

    enum MoneyFormat {
        MONEY_FORMAT("#,##0");

        private final String text;

        MoneyFormat(final String text) {
            this.text = text;
        }
    }

    enum Character {
        WON("원"),
        EA("개"),
        SPACE(" "),
        LINE_SEPARATOR("\n");

        private final String text;

        Character(final String text) {
            this.text = text;
        }
    }
}
