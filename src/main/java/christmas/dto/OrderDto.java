package christmas.dto;

import christmas.constant.menu.Menu;
import christmas.constant.number.Amount;
import christmas.model.Benefits;
import christmas.model.Order;
import christmas.util.Formatter;
import java.util.EnumMap;
import java.util.Objects;

public record OrderDto(EnumMap<Menu, Integer> menuAndCount) {
    public static OrderDto from(final Order order) {
        Objects.requireNonNull(order);

        return new OrderDto(order.menuAndCount());
    }

    public static OrderDto from(String inputMenuAndCount) {
        Objects.requireNonNull(inputMenuAndCount);

        return OrderDto.from(
                Order.from(inputMenuAndCount)
        );
    }

    public Order toModel() {
        return Order.from(
                this.menuAndCount
        );
    }

    @Override
    public String toString() {
        return Formatter.formatOrder(menuAndCount);
    }


    public PreDiscountAmountDto calculatePreDiscountAmountDto() {
        return PreDiscountAmountDto.from(
                this.toModel()
                        .calculatePreDiscountAmount()
        );
    }

    public BenefitsDto calculateBenefitsDtoFrom(
            final VisitDateDto visitDateDto,
            final PreDiscountAmountDto preDiscountAmountDto) {
        if (preDiscountAmountDto.isUnder(Amount.EVENT_CRITERIA)) {
            return BenefitsDto.withoutAnyBenefit();
        }
        return BenefitsDto.from(
                Benefits.from(
                        visitDateDto.toModel(),
                        this.toModel()
                )
        );
    }
}
