package christmas.constant.benefit;

import christmas.constant.number.Amount;
import christmas.constant.calendar.Period;
import christmas.constant.menu.MenuCategory.Menu;
import christmas.model.Order;
import christmas.model.PreDiscountAmount;
import christmas.model.VisitDate;
import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum DecemberEventBenefit implements Benefit {
    D_DAY_DISCOUNT("크리스마스 디데이 할인", (visitDate, orderedMenu) -> {
        if (Period.CHRISTMAS_D_Day_Event.includes(visitDate.getDayOfMonth())) {
            return dDayDiscountUnitAmount.multiply(
                    BigDecimal.valueOf(
                            visitDate.getDayOfMonth()
                    )
            );
        }
        return BigDecimal.ZERO;
    }),
    WEEKDAY_DISCOUNT("평일 할인", (visitDate, orderedMenu) -> {
        if (visitDate.isWeekDay()) {
            Map<Menu, Integer> menuAndCount = orderedMenu.getMenuAndCount();
            return menuAndCount.keySet()
                    .stream()
                    .filter(Menu::isDessert)
                    .map(menu -> Amount.WEEKDAYS_DISCOUNT_UNIT.multiply(
                            BigDecimal.valueOf(menuAndCount.get(menu))))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        return BigDecimal.ZERO;
    }),
    WEEKEND_DISCOUNT("주말 할인", (visitDate, orderedMenu) -> {
        if (visitDate.isWeekend()) {
            Map<Menu, Integer> menuAndCount = orderedMenu.getMenuAndCount();
            return menuAndCount.keySet()
                    .stream()
                    .filter(Menu::isMainMenu)
                    .map(menu -> Amount.WEEKEND_DISCOUNT_UNIT.multiply(
                            BigDecimal.valueOf(menuAndCount.get(menu))))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        return BigDecimal.ZERO;

    }),
    SPECIAL_DISCOUNT("특별 할인", (visitDate, orderedMenu) -> {
        if (visitDate.isStarredDate()) {
            Map<Menu, Integer> menuAndCount = orderedMenu.getMenuAndCount();
            return menuAndCount.keySet()
                    .stream()
                    .filter(Menu::isMainMenu)
                    .map(menu -> Amount.SPECIAL_DISCOUNT_UNIT.multiply(
                            BigDecimal.valueOf(menuAndCount.get(menu))))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        return BigDecimal.ZERO;
    }),
    GIVEAWAY("증정 이벤트", (visitDate, orderedMenu) -> {
        if (PreDiscountAmount.from(orderedMenu).isGreaterThan(BigDecimal.valueOf(120000))) {
            return Menu.CHAMPAGNE.getPrice();
        }
        return BigDecimal.ZERO;
    }),
    NOTHING("없음", (visitDate, orderedMenu) -> BigDecimal.ZERO);

    private final String name;
    private final BiFunction<VisitDate, Order, BigDecimal> condition;

    DecemberEventBenefit(final String name, final BiFunction<VisitDate, Order, BigDecimal> condition) {
        this.name = name;
        this.condition = condition;
    }

    public static EnumMap<DecemberEventBenefit, BigDecimal> calculate(
            final VisitDate visitDate,
            final Order order
    ) {
        EnumMap<DecemberEventBenefit, BigDecimal> benefits = new EnumMap<>(DecemberEventBenefit.class);
        for (DecemberEventBenefit decemberEventBenefit : values()) {
            if (!decemberEventBenefit.condition.apply(visitDate, order).equals(BigDecimal.ZERO)) {
                benefits.put(decemberEventBenefit, decemberEventBenefit.condition.apply(visitDate, order));
            }
        }
        return benefits;
    }

    public String getName() {
        return name;
    }
}
