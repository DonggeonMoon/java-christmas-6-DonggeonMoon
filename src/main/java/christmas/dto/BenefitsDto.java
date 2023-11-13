package christmas.dto;


import christmas.constant.benefit.Benefit;
import christmas.model.Benefits;
import java.math.BigDecimal;
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
        StringBuilder stringBuilder = new StringBuilder();
        benefits.entrySet()
                .forEach(benefitAndAmount -> {
                            stringBuilder.append(benefitAndAmount.getKey().getName());
                            stringBuilder.append(" ");
                            stringBuilder.append(benefitAndAmount.getValue());
                            stringBuilder.append("원");
                            stringBuilder.append("\n");
                        }
                );
        return stringBuilder.toString();
    }
}
