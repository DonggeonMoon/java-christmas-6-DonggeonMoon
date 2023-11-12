package christmas.model;

import java.math.BigDecimal;

public record PostDiscountAmount(
        BigDecimal amount
) {
    public static PostDiscountAmount from(BigDecimal amount) {
        return new PostDiscountAmount(amount);
    }
    public static PostDiscountAmount of(PreDiscountAmount preDiscountAmount, TotalBenefitAmount totalBenefitAmount) {
        BigDecimal subtracted = preDiscountAmount.subtract(totalBenefitAmount);
        return new PostDiscountAmount(subtracted);
    }
}
