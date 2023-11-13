package christmas.model;

import static christmas.constant.benefit.Benefit.GIVEAWAY;

import christmas.constant.benefit.Benefit;
import java.math.BigDecimal;
import java.util.EnumMap;

public record Benefits(
        EnumMap<Benefit, BigDecimal> benefits
) {
    public static Benefits from(final EnumMap<Benefit, BigDecimal> benefits) {
        return new Benefits(benefits);
    }

    public static Benefits from(
            final VisitDate visitDate,
            final Order order
    ) {
        EnumMap<Benefit, BigDecimal> benefits = Benefit.calculate(visitDate, order);
        return new Benefits(benefits);
    }

    public boolean hasGiveaway() {
        return !this.getGiveawayAmount().equals(BigDecimal.ZERO);
    }

    public BigDecimal getGiveawayAmount() {
        if (benefits.get(GIVEAWAY) == null) {
            return BigDecimal.ZERO;
        }
        return benefits.get(GIVEAWAY);
    }
}
