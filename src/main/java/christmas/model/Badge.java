package christmas.model;

public record Badge(
        christmas.constant.Badge badge
) {
    public static Badge from(TotalBenefitAmount totalBenefitAmount) {
        return new Badge(christmas.constant.Badge.from(totalBenefitAmount));
    }
}
