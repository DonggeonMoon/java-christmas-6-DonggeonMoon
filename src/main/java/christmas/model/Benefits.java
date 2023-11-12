package christmas.model;

import christmas.constant.benefit.Benefit;
import java.math.BigDecimal;
import java.util.EnumMap;

public record Benefits(
        EnumMap<Benefit, BigDecimal> benefits
) {
    public static Benefits from(
            VisitDate visitDate,
            OrderedMenu orderedMenu
    ) {
        EnumMap<Benefit, BigDecimal> benefits = new EnumMap<>(Benefit.class);
        benefits.put(
                Benefit.WEEKDAY_DISCOUNT,
                Benefit.WEEKDAY_DISCOUNT.calculateFrom(visitDate, orderedMenu)
        );
        return new Benefits(benefits);
    }
}
