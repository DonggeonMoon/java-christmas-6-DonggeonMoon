package christmas.constant.benefit;

import christmas.constant.Amounts;
import christmas.constant.Period;
import christmas.constant.menu.MenuCategory.Menu;
import christmas.model.OrderedMenu;
import christmas.model.PreDiscountAmount;
import christmas.model.VisitDate;
import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Benefit implements BenefitConstant {
    D_DAY_DISCOUNT("크리스마스 디데이 할인", (visitDate, orderedMenu) -> {
        if (Period.CHRISTMAS_D_Day_Event.includes(visitDate.getDayOfMonth())) {
            return dDayDiscountUnitAmount.multiply(
                    BigDecimal.valueOf(
                            visitDate.getDate().getDayOfMonth()
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
                    .map(menu -> Amounts.WEEKDAYS_DISCOUNT_UNIT_AMOUNT.getAmount()
                            .multiply(BigDecimal.valueOf(menuAndCount.get(menu))))
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
                    .map(menu -> Amounts.WEEKEND_DISCOUNT_UNIT_AMOUNT.getAmount()
                            .multiply(BigDecimal.valueOf(menuAndCount.get(menu))))
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
                    .map(menu -> Amounts.SPECIAL_DISCOUNT_UNIT_AMOUNT.getAmount()
                            .multiply(BigDecimal.valueOf(menuAndCount.get(menu))))
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
    private final BiFunction<VisitDate, OrderedMenu, BigDecimal> condition;

    Benefit(final String name, final BiFunction<VisitDate, OrderedMenu, BigDecimal> condition) {
        this.name = name;
        this.condition = condition;
    }

    public String getName() {
        return name;
    }

    public static EnumMap<Benefit, BigDecimal> calculate(VisitDate visitDate, OrderedMenu orderedMenu) {
        EnumMap<Benefit, BigDecimal> benefits = new EnumMap<>(Benefit.class);
        for (Benefit benefit : values()) {
            if (!benefit.condition.apply(visitDate, orderedMenu).equals(BigDecimal.ZERO)) {
                benefits.put(benefit, benefit.condition.apply(visitDate, orderedMenu));
            }
        }
        return benefits;
    }

    private BigDecimal calculateFrom(VisitDate visitDate, OrderedMenu orderedMenu) {
        return this.condition.apply(visitDate, orderedMenu);
    }
}
