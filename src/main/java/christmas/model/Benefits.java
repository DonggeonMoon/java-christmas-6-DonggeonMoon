package christmas.model;

import static christmas.constant.benefit.Benefit.GIVEAWAY;
import static christmas.constant.benefit.Benefit.SPECIAL_DISCOUNT;
import static christmas.constant.benefit.Benefit.WEEKDAY_DISCOUNT;
import static christmas.constant.benefit.Benefit.WEEKEND_DISCOUNT;

import christmas.constant.benefit.Benefit;
import java.math.BigDecimal;
import java.util.EnumMap;

public record Benefits(
        EnumMap<Benefit, BigDecimal> benefits
) {
    public static Benefits from(EnumMap<Benefit, BigDecimal> benefits) {
        return new Benefits(benefits);
    }

    public static Benefits from(
            VisitDate visitDate,
            OrderedMenu orderedMenu
    ) {
        EnumMap<Benefit, BigDecimal> benefits = new EnumMap<>(Benefit.class);
        benefits.put(
                WEEKDAY_DISCOUNT,
                WEEKDAY_DISCOUNT.calculateFrom(visitDate, orderedMenu)
        );
        benefits.put(
                WEEKEND_DISCOUNT,
                WEEKEND_DISCOUNT.calculateFrom(visitDate, orderedMenu)
        );
        benefits.put(
                SPECIAL_DISCOUNT,
                SPECIAL_DISCOUNT.calculateFrom(visitDate, orderedMenu)
        );
        benefits.put(
                GIVEAWAY,
                GIVEAWAY.calculateFrom(visitDate, orderedMenu)
        );
        return new Benefits(benefits);
    }

    public boolean hasGiveaway() {
        return !this.getGiveawayAmount().equals(BigDecimal.ZERO);
    }

    public BigDecimal getGiveawayAmount() {
        return benefits.get(GIVEAWAY);
    }

    public TotalBenefitAmount calculateTotalBenefitAmount() {
        return TotalBenefitAmount.from(this);
    }
}
