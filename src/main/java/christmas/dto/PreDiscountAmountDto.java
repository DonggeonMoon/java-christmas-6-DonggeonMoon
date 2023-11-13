package christmas.dto;

import christmas.model.PreDiscountAmount;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public record PreDiscountAmountDto(
        BigDecimal amount
) {
    public static PreDiscountAmountDto from(final PreDiscountAmount preDiscountAmount) {
        return new PreDiscountAmountDto(preDiscountAmount.amount());
    }

    public PreDiscountAmount toModel() {
        return PreDiscountAmount.from(amount);
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
