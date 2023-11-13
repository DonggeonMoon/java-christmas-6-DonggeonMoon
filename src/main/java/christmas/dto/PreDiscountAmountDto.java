package christmas.dto;

import christmas.util.Formatter;
import christmas.model.PreDiscountAmount;
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

    public PostDiscountAmountDto calculatePostDiscountAmountDto(TotalBenefitAmountDto totalBenefitAmountDto) {
        return PostDiscountAmountDto.from(
                this.toModel()
                        .subtract(
                                totalBenefitAmountDto.toModel()
                        )
        );
    }
}
