package christmas.constant.benefit;

import static christmas.constant.number.Amount.D_DAY_EVENT_DISCOUNT_BASE;
import static christmas.constant.number.Amount.GIVEAWAY_CRITERIA;
import static christmas.constant.number.Amount.SPECIAL_DISCOUNT_UNIT;
import static christmas.constant.number.Amount.WEEKDAYS_DISCOUNT_UNIT;
import static christmas.constant.number.Amount.WEEKEND_DISCOUNT_UNIT;

import christmas.constant.calendar.Period;
import christmas.constant.menu.Menu;
import christmas.model.Order;
import christmas.model.PreDiscountAmount;
import christmas.model.VisitDate;
import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

public enum DecemberEventBenefit implements Benefit {
    D_DAY_DISCOUNT("크리스마스 디데이 할인", (visitDate, order) -> {
        if (Period.CHRISTMAS_D_DAY_EVENT.notIncludes(visitDate.calculateDayOfMonth())) {
            return BigDecimal.ZERO;
        }
        return D_DAY_EVENT_DISCOUNT_BASE.add(
                dDayDiscountUnitAmount.multiply(
                        visitDate.calculateDayOfMonthInBigDecimal().subtract(BigDecimal.ONE)
                )
        );
    }),
    WEEKDAY_DISCOUNT("평일 할인", (visitDate, order) -> {
        if (visitDate.isWeekend()) {
            return BigDecimal.ZERO;
        }
        Map<Menu, Integer> menuAndCount = order.menuAndCount();
        return menuAndCount.keySet()
                .stream()
                .filter(Menu::isDessert)
                .map(menu -> WEEKDAYS_DISCOUNT_UNIT.multiply(
                        BigDecimal.valueOf(menuAndCount.get(menu))))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }),
    WEEKEND_DISCOUNT("주말 할인", (visitDate, order) -> {
        if (visitDate.isWeekDay()) {
            return BigDecimal.ZERO;
        }
        Map<Menu, Integer> menuAndCount = order.menuAndCount();
        return menuAndCount.keySet()
                .stream()
                .filter(Menu::isMainMenu)
                .map(menu -> WEEKEND_DISCOUNT_UNIT.multiply(
                        BigDecimal.valueOf(menuAndCount.get(menu))))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }),
    SPECIAL_DISCOUNT("특별 할인", (visitDate, order) -> {
        if (visitDate.isNotStarredDate()) {
            return BigDecimal.ZERO;

        }
        return SPECIAL_DISCOUNT_UNIT.getValue();
    }),
    GIVEAWAY("증정 이벤트", (visitDate, order) -> {
        PreDiscountAmount preDiscountAmount = order.calculatePreDiscountAmount();
        if (preDiscountAmount.isGreaterThan(GIVEAWAY_CRITERIA)) {
            return Menu.CHAMPAGNE.getPrice();
        }
        return BigDecimal.ZERO;
    }),
    NOTHING("없음", (visitDate, order) -> BigDecimal.ZERO);

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
        Objects.requireNonNull(visitDate);
        Objects.requireNonNull(order);

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
