package christmas.dto;

import christmas.util.Formatter;
import christmas.model.PostDiscountAmount;
import java.math.BigDecimal;
import java.util.Objects;

public record PostDiscountAmountDto(
        BigDecimal amount
) {
    public static PostDiscountAmountDto from(final PostDiscountAmount postDiscountAmount) {
        Objects.requireNonNull(postDiscountAmount);

        return new PostDiscountAmountDto(postDiscountAmount.amount());
    }

    @Override
    public String toString() {
        return Formatter.formatAmount(amount);
    }
}
