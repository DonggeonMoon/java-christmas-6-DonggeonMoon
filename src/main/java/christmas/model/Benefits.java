package christmas.model;

import static christmas.constant.benefit.DecemberEventBenefit.GIVEAWAY;

import christmas.constant.benefit.DecemberEventBenefit;
import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Objects;

public record Benefits(
        EnumMap<DecemberEventBenefit, BigDecimal> benefits
) {
    public static Benefits from(final EnumMap<DecemberEventBenefit, BigDecimal> benefits) {
        Objects.requireNonNull(benefits);

        return new Benefits(benefits);
    }

    public static Benefits from(
            final VisitDate visitDate,
            final Order order
    ) {
        Objects.requireNonNull(visitDate);
        Objects.requireNonNull(order);

        EnumMap<DecemberEventBenefit, BigDecimal> benefits = DecemberEventBenefit.calculate(visitDate, order);
        return new Benefits(benefits);
    }

    public boolean hasGiveaway() {
        return !this.calculateGiveawayAmount().equals(BigDecimal.ZERO);
    }

    public BigDecimal calculateGiveawayAmount() {
        if (benefits.get(GIVEAWAY) == null) {
            return BigDecimal.ZERO;
        }
        return benefits.get(GIVEAWAY);
    }

    public GiveawayMenu calculateGiveawayMenu() {
        return GiveawayMenu.from(this);
    }

    public TotalBenefitAmount calculateTotalBenefitAmount() {
        return TotalBenefitAmount.from(this);
    }
}
