package christmas.dto;


import christmas.constant.benefit.Benefit;
import christmas.model.Benefits;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.EnumMap;

public record BenefitsDto(
        EnumMap<Benefit, BigDecimal> benefits
) {
    public static BenefitsDto from(Benefits benefits) {
        return new BenefitsDto(benefits.benefits());
    }

    public Benefits toEntity() {
        return Benefits.from(benefits);
    }

    @Override
    public String toString() {
        if (benefits.isEmpty()) {
            return Benefit.NOTHING.getName() + "\n";
        }

        NumberFormat numberFormat = new DecimalFormat("#,##0");
        StringBuilder stringBuilder = new StringBuilder();
        benefits.forEach((key, value) -> {
            stringBuilder.append(key.getName());
            stringBuilder.append(" ");
            stringBuilder.append(numberFormat.format(value));
            stringBuilder.append("원");
            stringBuilder.append("\n");
        });
        return stringBuilder.toString();
    }
}
