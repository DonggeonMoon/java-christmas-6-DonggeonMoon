package christmas.dto;

import christmas.model.PostDiscountAmount;
import java.math.BigDecimal;

public record PostDiscountAmountDto(
        BigDecimal amount
) {
    public static PostDiscountAmountDto from(PostDiscountAmount postDiscountAmount) {
        return new PostDiscountAmountDto(postDiscountAmount.amount());
    }

    public PostDiscountAmount toEntity() {
        return PostDiscountAmount.from(amount);
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
