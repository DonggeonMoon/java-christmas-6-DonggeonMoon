package christmas.dto;

import christmas.constant.menu.MenuCategory.Menu;
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

    public BenefitsDto calculateBenefitsDtoFrom(VisitDateDto visitDateDto) {
        return BenefitsDto.from(
                Benefits.from(
                        visitDateDto.toModel(),
                        this.toModel()
                )
        );
    }
}
