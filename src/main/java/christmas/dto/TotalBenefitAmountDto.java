package christmas.dto;

import christmas.util.Formatter;
import christmas.model.TotalBenefitAmount;
import java.math.BigDecimal;
import java.util.Objects;

public record TotalBenefitAmountDto(
        BigDecimal amount
) {
    public static TotalBenefitAmountDto from(final TotalBenefitAmount totalBenefitAmount) {
        Objects.requireNonNull(totalBenefitAmount);

        return new TotalBenefitAmountDto(totalBenefitAmount.amount());
    }

    public TotalBenefitAmount toModel() {
        return new TotalBenefitAmount(amount);
    }

    @Override
    public String toString() {
        return Formatter.formatTotalBenefitAmount(amount);
    }

    public EventBadgeDto calculateEventBadgeDto() {
        return EventBadgeDto.from(
                this.toModel()
                        .calculateEventBadge()
        );
    }
}
