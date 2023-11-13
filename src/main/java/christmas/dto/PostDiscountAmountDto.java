package christmas.dto;

import christmas.model.PostDiscountAmount;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public record PostDiscountAmountDto(
        BigDecimal amount
) {
    public static PostDiscountAmountDto from(final PostDiscountAmount postDiscountAmount) {
        return new PostDiscountAmountDto(postDiscountAmount.amount());
    }

    @Override
    public String toString() {
        NumberFormat numberFormat = new DecimalFormat("#,##0");
        return numberFormat.format(amount)
                + "원"
                + "\n";
    }
}
