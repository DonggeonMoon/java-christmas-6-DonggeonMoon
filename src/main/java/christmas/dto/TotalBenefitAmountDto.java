package christmas.dto;

import christmas.model.TotalBenefitAmount;
import java.math.BigDecimal;

public record TotalBenefitAmountDto(
        BigDecimal amount
) {
    public static TotalBenefitAmountDto from(TotalBenefitAmount totalBenefitAmount) {
        return new TotalBenefitAmountDto(totalBenefitAmount.amount());
    }
}
