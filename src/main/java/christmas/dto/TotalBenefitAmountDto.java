package christmas.dto;

import christmas.model.TotalBenefitAmount;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public record TotalBenefitAmountDto(
        BigDecimal amount
) {
    public static TotalBenefitAmountDto from(final TotalBenefitAmount totalBenefitAmount) {
        return new TotalBenefitAmountDto(totalBenefitAmount.amount());
    }

    public TotalBenefitAmount toEntity() {
        return new TotalBenefitAmount(amount);
    }

    @Override
    public String toString() {
        NumberFormat numberFormat = new DecimalFormat("#,##0");
        final String stringBuilder = numberFormat.format(amount)
                + "원"
                + "\n";
        return stringBuilder;
    }
}
