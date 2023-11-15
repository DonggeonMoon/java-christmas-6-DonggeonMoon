package christmas.stub;

import christmas.constant.badge.Badge;
import christmas.constant.benefit.DecemberEventBenefit;
import christmas.constant.menu.Menu;
import christmas.dto.BenefitsDto;
import christmas.dto.EventBadgeDto;
import christmas.dto.GiveawayMenuDto;
import christmas.dto.OrderDto;
import christmas.dto.PostDiscountAmountDto;
import christmas.dto.PreDiscountAmountDto;
import christmas.dto.TotalBenefitAmountDto;
import christmas.dto.VisitDateDto;
import christmas.model.Benefits;
import christmas.model.EventBadge;
import christmas.model.GiveawayMenu;
import christmas.model.Order;
import christmas.model.PostDiscountAmount;
import christmas.model.PreDiscountAmount;
import christmas.model.TotalBenefitAmount;
import christmas.model.VisitDate;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.EnumMap;
import java.util.Map;

public interface UnitTestStub {
    LocalDate DECEMBER_THIRD = LocalDate.of(2023, 12, 3);
    LocalDate DECEMBER_FIFTH = LocalDate.of(2023, 12, 5);
    EnumMap<DecemberEventBenefit, BigDecimal> BENEFIT_AND_AMOUNT = new EnumMap<>(
            Map.of(DecemberEventBenefit.D_DAY_DISCOUNT, BigDecimal.valueOf(1200), DecemberEventBenefit.WEEKEND_DISCOUNT,
                    BigDecimal.valueOf(2023), DecemberEventBenefit.SPECIAL_DISCOUNT, BigDecimal.valueOf(1000),
                    DecemberEventBenefit.GIVEAWAY, BigDecimal.valueOf(25000)));
    EnumMap<DecemberEventBenefit, BigDecimal> BENEFIT_AND_AMOUNT2 = new EnumMap<>(
            DecemberEventBenefit.class);
    EnumMap<DecemberEventBenefit, BigDecimal> EMPTY_ENUM_MAP = new EnumMap<>(
            DecemberEventBenefit.class);
    EnumMap<Menu, Integer> MENU_AND_COUNT = new EnumMap<>(
            Map.of(Menu.SEAFOOD_PASTA, 2, Menu.RED_WINE, 1, Menu.CHOCOLATE_CAKE, 1));
    EnumMap<Menu, Integer> MENU_AND_COUNT2 = new EnumMap<>(
            Map.of(Menu.SEAFOOD_PASTA, 1, Menu.RED_WINE, 1, Menu.CHOCOLATE_CAKE, 1));
    EnumMap<DecemberEventBenefit, BigDecimal> BENEFIT_AND_AMOUNT3 = new EnumMap<>(
            Map.of(DecemberEventBenefit.D_DAY_DISCOUNT, BigDecimal.valueOf(1200), DecemberEventBenefit.WEEKDAY_DISCOUNT,
                    BigDecimal.valueOf(2023), DecemberEventBenefit.SPECIAL_DISCOUNT, BigDecimal.valueOf(1000),
                    DecemberEventBenefit.GIVEAWAY, BigDecimal.valueOf(25000)));
    EnumMap<DecemberEventBenefit, BigDecimal> BENEFIT_AND_AMOUNT4 = new EnumMap<>(
            Map.of(DecemberEventBenefit.D_DAY_DISCOUNT, BigDecimal.valueOf(1700), DecemberEventBenefit.WEEKEND_DISCOUNT,
                    BigDecimal.valueOf(2023)));
    EnumMap<DecemberEventBenefit, BigDecimal> BENEFIT_AND_AMOUNT5 = new EnumMap<>(
            Map.of(DecemberEventBenefit.WEEKDAY_DISCOUNT, BigDecimal.valueOf(2023)));
    String VALID_INPUT = "해산물파스타-2,레드와인-1,초코케이크-1";
    VisitDate VISIT_DATE = VisitDate.from(LocalDate.of(2023, 12, 3));
    VisitDate VISIT_DATE_FROM_THREE = VisitDate.from(3);
    VisitDate VISIT_DATE_FROM_EIGHT = VisitDate.from(8);
    VisitDate VISIT_DATE_FROM_TWENTY_SIX = VisitDate.from(26);

    VisitDateDto VISIT_DATE_DTO = VisitDateDto.from(VISIT_DATE);
    Order ORDER = Order.from(VALID_INPUT);
    Order ORDER2 = Order.from(MENU_AND_COUNT2);
    OrderDto ORDER_DTO = OrderDto.from(ORDER);
    Benefits BENEFITS = Benefits.from(VISIT_DATE, ORDER);
    Benefits EMPTY_BENEFITS = Benefits.from(EMPTY_ENUM_MAP);
    BenefitsDto BENEFITS_DTO = BenefitsDto.from(BENEFITS);
    String BENEFITS_DTO_MESSAGE = """
            크리스마스 디데이 할인 1,200원
            평일 할인 2,023원
            특별 할인 1,000원
            증정 이벤트 25,000원""";
    String PRE_DISCOUNT_AMOUNT_DTO_MESSAGE = "145,000원";
    String ORDER_DTO_MESSAGE = """
            해산물파스타 2개
            초코케이크 1개
            레드와인 1개
            """;
    String TOTAL_BENEFIT_AMOUNT_DTO_MESSAGE = "-29,223원";

    String PRE_DISCOUNT_AMOUNT_MESSAGE = "145,000원";
    String POST_DISCOUNT_AMOUNT_DTO_MESSAGE = "1,000원";
    BenefitsDto EMPTY_BENEFIT_DTO = BenefitsDto.from(EMPTY_BENEFITS);
    GiveawayMenu GIVEAWAY_MENU = GiveawayMenu.from(BENEFITS);
    GiveawayMenuDto GIVEAWAY_MENU_DTO = GiveawayMenuDto.from(GIVEAWAY_MENU);
    String GIVEAWAY_DTO_MESSAGE = "샴페인 1개";
    TotalBenefitAmount TOTAL_BENEFIT_AMOUNT = BENEFITS.calculateTotalBenefitAmount();
    TotalBenefitAmountDto TOTAL_BENEFIT_AMOUNT_DTO = TotalBenefitAmountDto.from(TOTAL_BENEFIT_AMOUNT);
    EventBadge EVENT_BADGE = EventBadge.from(TOTAL_BENEFIT_AMOUNT);
    EventBadgeDto EVENT_BADGE_DTO = EventBadgeDto.from(EVENT_BADGE);
    PreDiscountAmount PRE_DISCOUNT_AMOUNT = PreDiscountAmount.from(ORDER);
    PreDiscountAmountDto PRE_DISCOUNT_AMOUNT_DTO = PreDiscountAmountDto.from(PRE_DISCOUNT_AMOUNT);
    PostDiscountAmount POST_DISCOUNT_AMOUNT = PostDiscountAmount.from(BigDecimal.valueOf(1000));
    PostDiscountAmount POST_DISCOUNT_AMOUNT2 = PostDiscountAmount.from(BigDecimal.valueOf(115777));
    PostDiscountAmountDto POST_DISCOUNT_AMOUNT_DTO = PostDiscountAmountDto.from(POST_DISCOUNT_AMOUNT2);
    LocalDate WEEKEND_DATE = LocalDate.of(2023, 12, 1);

    LocalDate WEEKDAY_AND_STARRED_DATE = LocalDate.of(2023, 12, 3);
    BigDecimal ONE_HUNDRED_THIRTY_THOUSAND = BigDecimal.valueOf(130000);
    int EXPECTED_DAY_OF_MONTH = 1;
    BigDecimal EXPECTED_DAY_OF_MONTH_IN_BIGDECIMAL = BigDecimal.ONE;
    BigDecimal EXPECTED_TOTAL_BENEFIT_AMOUNT = BigDecimal.valueOf(29223);
    String EXPECTED_BADGE_NAME = Badge.SANTA.getName();
    PostDiscountAmount EXPECTED_POST_DISCOUNT_AMOUNT = PostDiscountAmount.from(BigDecimal.valueOf(115777));
    BigDecimal THOUSAND = BigDecimal.valueOf(1000);
    BigDecimal TEN_THOUSAND = BigDecimal.valueOf(10000);
    BigDecimal ONE_POINT_TWO_BILLION = BigDecimal.valueOf(1200000000);
    BigDecimal PRE_DISCOUNT_AMOUNT_IN_BIG_DECIMAL = BigDecimal.valueOf(145000);
    EnumMap<Menu, Integer> EXPECTED_MENU_AND_COUNT = new EnumMap<>(
            Map.of(Menu.CHAMPAGNE, 1));
    PreDiscountAmount PRE_DISCOUNT_AMOUNT2 = PreDiscountAmount.from(
            PRE_DISCOUNT_AMOUNT_IN_BIG_DECIMAL);
}
