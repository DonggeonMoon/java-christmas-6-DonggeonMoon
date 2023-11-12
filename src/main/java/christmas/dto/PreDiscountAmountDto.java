package christmas.dto;

import christmas.model.PreDiscountAmount;
import java.math.BigDecimal;

public record PreDiscountAmountDto(
        BigDecimal amount
) {
    public static PreDiscountAmountDto from(PreDiscountAmount preDiscountAmount) {
        return new PreDiscountAmountDto(preDiscountAmount.amount());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(amount);
        stringBuilder.append("원");
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
