package christmas.ui;

import static christmas.constant.string.Message.BADGE_PREFIX;
import static christmas.constant.string.Message.EVENT_BENEFIT_PREVIEW;
import static christmas.constant.string.Message.EVENT_PLANNER;
import static christmas.constant.string.Message.MENU_AND_COUNT_INPUT_PROMPT;
import static christmas.constant.string.Message.ORDERED_MENU_PREFIX;
import static christmas.constant.string.Message.VISIT_DATE_INPUT_PROMPT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.constant.exception.ArgumentException;
import christmas.dto.EventBadgeDto;
import christmas.dto.BenefitsDto;
import christmas.dto.GiveawayMenuDto;
import christmas.dto.OrderDto;
import christmas.dto.PostDiscountAmountDto;
import christmas.dto.PreDiscountAmountDto;
import christmas.dto.TotalBenefitAmountDto;
import christmas.model.EventBadge;
import christmas.model.Benefits;
import christmas.model.GiveawayMenu;
import christmas.model.Order;
import christmas.model.PostDiscountAmount;
import christmas.model.PreDiscountAmount;
import christmas.model.TotalBenefitAmount;
import christmas.model.VisitDate;
import christmas.view.ChristmasInputView;
import christmas.view.ChristmasOutputView;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ChristmasUiTest extends UiTest {
    private static final String validInput = "해산물파스타-2,레드와인-1,초코케이크-1";
    public static final CharSequence[] ORDERED_MENU_DTO_TEXT_COMPONENT = {
            ORDERED_MENU_PREFIX.getText(),
            "레드와인 1개",
            "해산물파스타 2개",
            "초코케이크 1개"
    };
    public static final String PRE_DISCOUNT_AMOUNT_TEXT = "145,000원";
    public static final String GIVEAWAY_TEXT = "샴페인 1개";
    public static final String[] BENEFIT_TEXT = {
            "평일 할인 2,023원",
            "특별 할인 2,000원",
            "증정 이벤트 25,000원"};
    public static final String TOTAL_BENEFIT_AMOUNT_TEXT = "30,323원";
    public static final List<String> POST_DISCOUNT_AMOUNT_COMPONENT = List.of(
            "<할인 후 예상 결제 금액>",
            "114,677원"
    );
    public static final List<String> BADGE_COMPONENT = List.of(
            BADGE_PREFIX.getText(),
            "산타"
    );
    private ChristmasOutputView outputView;
    private ChristmasInputView inputView;
    private VisitDate visitDate;
    private Order order;
    private OrderDto orderDto;
    private PreDiscountAmount preDiscountAmount;
    private PreDiscountAmountDto preDiscountAmountDto;
    private Benefits benefits;
    private BenefitsDto benefitsDto;
    private GiveawayMenu giveawayMenu;
    private GiveawayMenuDto giveawayMenuDto;
    private TotalBenefitAmount totalBenefitAmount;
    private TotalBenefitAmountDto totalBenefitAmountDto;
    private PostDiscountAmount postDiscountAmount;
    private PostDiscountAmountDto postDiscountAmountDto;
    private EventBadge badge;
    private EventBadgeDto eventBadgeDto;


    @BeforeEach
    void setUp() {
        outputView = ChristmasOutputView.create();
        inputView = ChristmasInputView.create();
        visitDate = VisitDate.from(LocalDate.of(2023, 12, 3));
        order = Order.from(validInput);
        orderDto = OrderDto.from(order);
        preDiscountAmount = PreDiscountAmount.from(order);
        preDiscountAmountDto = PreDiscountAmountDto.from(preDiscountAmount);
        benefits = Benefits.from(visitDate, order);
        benefitsDto = BenefitsDto.from(benefits);
        giveawayMenu = GiveawayMenu.from(benefits);
        giveawayMenuDto = GiveawayMenuDto.from(giveawayMenu);
        totalBenefitAmount = TotalBenefitAmount.from(benefits);
        totalBenefitAmountDto = TotalBenefitAmountDto.from(totalBenefitAmount);
        postDiscountAmount = PostDiscountAmount.of(preDiscountAmount, totalBenefitAmount);
        postDiscountAmountDto = PostDiscountAmountDto.from(postDiscountAmount);
        badge = EventBadge.from(totalBenefitAmount);
        eventBadgeDto = EventBadgeDto.from(badge);
    }

    @Test
    void printEventPlannerMessage() {
        outputView.printEventPlannerMessage();

        assertThat(getOutput())
                .contains(EVENT_PLANNER.getText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "31"})
    void readVisitDate(String input) {
        input(input);
        inputView.readVisitDate();

        assertThat(getOutput())
                .contains(VISIT_DATE_INPUT_PROMPT.getText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "31"})
    void readVisitDate2(String input) {
        input(input);
        int inputDay = inputView.readVisitDate();

        assertThat(inputDay)
                .isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {",", "  "})
    void readVisitDate3(String input) throws NoSuchElementException {
        input(input);

        assertThatThrownBy(() -> inputView.readVisitDate())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ArgumentException.INVALID_DATE.exception().getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-2,레드와인-1,초코케이크-1"})
    void readMenuAndCount(String input) {
        input(input);
        inputView.readMenuAndCount();

        assertThat(getOutput())
                .contains(MENU_AND_COUNT_INPUT_PROMPT.getText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"해산물파스타-2,레드와인-1,초코케이크-1"})
    void readMenuAndCount2(String input) {
        input(input);
        String inputMenuAndCount = inputView.readMenuAndCount();

        assertThat(inputMenuAndCount)
                .isEqualTo(input);
    }

    @Test
    void printEventBenefitPreview() {
        outputView.printEventBenefitPreview();
        assertThat(getOutput())
                .contains(EVENT_BENEFIT_PREVIEW.getText());
    }

    @Test
    void printOrderedMenu() {
        outputView.printOrderedMenu(orderDto);
        assertThat(getOutput())
                .contains(ORDERED_MENU_DTO_TEXT_COMPONENT
                );
    }

    @Test
    void printPreDiscountAmount() {
        outputView.printPreDiscountAmount(preDiscountAmountDto);
        assertThat(getOutput())
                .contains(PRE_DISCOUNT_AMOUNT_TEXT);
    }

    @Test
    void printGiveaway() {
        outputView.printGiveaway(giveawayMenuDto);
        assertThat(getOutput())
                .contains(GIVEAWAY_TEXT);
    }

    @Test
    void printBenefits() {
        outputView.printBenefits(benefitsDto);
        assertThat(getOutput())
                .contains(BENEFIT_TEXT);
    }

    @Test
    void printTotalBenefitAmount() {
        outputView.printTotalBenefitAmount(totalBenefitAmountDto);
        assertThat(getOutput())
                .contains(TOTAL_BENEFIT_AMOUNT_TEXT);
    }

    @Test
    void printPostDiscountAmount() {
        outputView.printPostDiscountAmount(postDiscountAmountDto);
        assertThat(getOutput())
                .contains(POST_DISCOUNT_AMOUNT_COMPONENT);
    }

    @Test
    void printBadge() {
        outputView.printBadge(eventBadgeDto);
        assertThat(getOutput())
                .contains(BADGE_COMPONENT);
    }
}
