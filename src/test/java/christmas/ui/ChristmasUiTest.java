package christmas.ui;

import static christmas.constant.Message.EVENT_BENEFIT_PREVIEW;
import static christmas.constant.Message.EVENT_PLANNER;
import static christmas.constant.Message.MENU_AND_COUNT_INPUT_PROMPT;
import static christmas.constant.Message.ORDERED_MENU_PREFIX;
import static christmas.constant.Message.VISIT_DATE_INPUT_PROMPT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.constant.exception.ArgumentException;
import christmas.dto.BenefitsDto;
import christmas.dto.GiveawayMenuDto;
import christmas.dto.OrderedMenuDto;
import christmas.dto.PreDiscountAmountDto;
import christmas.model.Benefits;
import christmas.model.GiveawayMenu;
import christmas.model.OrderedMenu;
import christmas.model.PreDiscountAmount;
import christmas.model.VisitDate;
import christmas.view.ChristmasInputView;
import christmas.view.ChristmasOutputView;
import java.time.LocalDate;
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
    public static final String PRE_DISCOUNT_AMOUNT_TEXT = "145000원";
    public static final String GIVEAWAY_TEXT = "샴페인 1개";
    private ChristmasOutputView outputView;
    private ChristmasInputView inputView;
    private VisitDate visitDate;
    private OrderedMenu orderedMenu;
    private OrderedMenuDto orderedMenuDto;
    private PreDiscountAmount preDiscountAmount;
    private PreDiscountAmountDto preDiscountAmountDto;
    private Benefits benefits;
    private BenefitsDto benefitsDto;
    private GiveawayMenu giveawayMenu;
    private GiveawayMenuDto giveawayMenuDto;

    @BeforeEach
    void setUp() {
        outputView = ChristmasOutputView.create();
        inputView = ChristmasInputView.create();
        visitDate = VisitDate.from(LocalDate.of(2023, 12, 3));
        orderedMenu = OrderedMenu.from(validInput);
        orderedMenuDto = OrderedMenuDto.from(orderedMenu);
        preDiscountAmount = PreDiscountAmount.from(orderedMenu);
        preDiscountAmountDto = PreDiscountAmountDto.from(preDiscountAmount);
        benefits = Benefits.from(visitDate, orderedMenu);
        benefitsDto = BenefitsDto.from(benefits);
        giveawayMenu = GiveawayMenu.from(benefits);
        giveawayMenuDto = GiveawayMenuDto.from(giveawayMenu);
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
        outputView.printOrderedMenu(orderedMenuDto);
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
}
