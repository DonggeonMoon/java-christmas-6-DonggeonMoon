package christmas.dto;

import christmas.model.TotalBenefitAmount;
import java.math.BigDecimal;

public record TotalBenefitAmountDto(
        BigDecimal amount
) {
    public static TotalBenefitAmountDto from(TotalBenefitAmount totalBenefitAmount) {
        return new TotalBenefitAmountDto(totalBenefitAmount.amount());
    }

    public TotalBenefitAmount toEntity() {
        return new TotalBenefitAmount(amount);
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
