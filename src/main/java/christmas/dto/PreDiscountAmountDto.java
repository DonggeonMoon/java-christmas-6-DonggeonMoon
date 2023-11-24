package christmas.dto;

import christmas.constant.number.Amount;
import christmas.model.PreDiscountAmount;
import christmas.util.Formatter;
import java.math.BigDecimal;
import java.util.Objects;

public record PreDiscountAmountDto(
        BigDecimal amount
) {
    public static PreDiscountAmountDto from(final PreDiscountAmount preDiscountAmount) {
        Objects.requireNonNull(preDiscountAmount);

        return new PreDiscountAmountDto(preDiscountAmount.amount());
    }

    public PreDiscountAmount toModel() {
        return PreDiscountAmount.from(amount);
    }

    @Override
    public String toString() {
        return Formatter.formatAmount(amount);
    }

    public PostDiscountAmountDto calculatePostDiscountAmountDto(final TotalBenefitAmountDto totalBenefitAmountDto) {
        Objects.requireNonNull(totalBenefitAmountDto);

        return PostDiscountAmountDto.from(
                this.toModel()
                        .subtract(
                                totalBenefitAmountDto.toModel()
                        )
        );
    }

    public boolean isUnder(final Amount criteriaAmount) {
        Objects.requireNonNull(criteriaAmount);

        return amount.compareTo(
                criteriaAmount.getValue()
        ) < 0;
    }
}
