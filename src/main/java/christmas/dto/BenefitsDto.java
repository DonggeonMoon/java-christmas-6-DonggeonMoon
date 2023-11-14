package christmas.dto;


import christmas.constant.benefit.DecemberEventBenefit;
import christmas.model.Benefits;
import christmas.util.Formatter;
import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Objects;

public record BenefitsDto(
        EnumMap<DecemberEventBenefit, BigDecimal> benefits
) {
    public static BenefitsDto from(final Benefits benefits) {
        Objects.requireNonNull(benefits);

        return new BenefitsDto(benefits.benefits());
    }

    public static BenefitsDto withoutAnyBenefit() {
        return new BenefitsDto(new EnumMap<>(DecemberEventBenefit.class));
    }

    public Benefits toModel() {
        return Benefits.from(benefits);
    }

    @Override
    public String toString() {
        return Formatter.formatBenefit(benefits);
    }

    public GiveawayMenuDto calculateGiveawayMenuDto() {
        return GiveawayMenuDto.from(
                this.toModel()
                        .calculateGiveawayMenu()
        );
    }

    public TotalBenefitAmountDto calculateTotalBenefitAmountDto() {
        return TotalBenefitAmountDto.from(
                this.toModel()
                        .calculateTotalBenefitAmount()
        );
    }
}
