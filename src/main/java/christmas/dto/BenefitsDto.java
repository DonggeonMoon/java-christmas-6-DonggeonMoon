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
}
