package christmas.ui;

import static christmas.constant.string.Message.EVENT_BENEFIT_PREVIEW;
import static christmas.constant.string.Message.EVENT_PLANNER;
import static christmas.constant.string.Message.MENU_AND_COUNT_INPUT_PROMPT;
import static christmas.constant.string.Message.VISIT_DATE_INPUT_PROMPT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.constant.exception.ArgumentException;
import christmas.dto.BenefitsDto;
import christmas.dto.EventBadgeDto;
import christmas.dto.GiveawayMenuDto;
import christmas.dto.OrderDto;
import christmas.dto.PostDiscountAmountDto;
import christmas.dto.PreDiscountAmountDto;
import christmas.dto.TotalBenefitAmountDto;
import christmas.model.Benefits;
import christmas.model.EventBadge;
import christmas.model.GiveawayMenu;
import christmas.model.Order;
import christmas.model.PostDiscountAmount;
import christmas.model.PreDiscountAmount;
import christmas.stub.UiTestStub;
import christmas.template.UiTest;
import christmas.view.ChristmasInputView;
import christmas.view.ChristmasOutputView;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ChristmasUiTest extends UiTest implements UiTestStub {
    @BeforeEach
    void setUp() {
        outputView = ChristmasOutputView.create();
        inputView = ChristmasInputView.create();
        order = Order.from(validInput);
        orderDto = OrderDto.from(order);
        preDiscountAmount = PreDiscountAmount.from(order);
        preDiscountAmountDto = PreDiscountAmountDto.from(preDiscountAmount);
        benefits = Benefits.from(VISIT_DATE, order);
        benefitsDto = BenefitsDto.from(benefits);
        giveawayMenu = GiveawayMenu.from(benefits);
        giveawayMenuDto = GiveawayMenuDto.from(giveawayMenu);
        totalBenefitAmount = benefits.calculateTotalBenefitAmount();
        totalBenefitAmountDto = TotalBenefitAmountDto.from(totalBenefitAmount);
        postDiscountAmount = PostDiscountAmount.of(preDiscountAmount, totalBenefitAmount);
        postDiscountAmountDto = PostDiscountAmountDto.from(postDiscountAmount);
        eventBadge = EventBadge.from(totalBenefitAmount);
        eventBadgeDto = EventBadgeDto.from(eventBadge);
    }

    @Test
    @DisplayName("이벤트 플래너 메시지 출력")
    void printEventPlannerMessage() {
        outputView.printEventPlannerMessage();

        assertThat(getOutput())
                .contains(EVENT_PLANNER.getText());
    }

    @ParameterizedTest
    @DisplayName("방문 일자 입력받기2")
    @ValueSource(strings = {"1", "2", "31"})
    void readVisitDate(String input) {
        input(input);
        inputView.readVisitDate();

        assertThat(getOutput())
                .contains(VISIT_DATE_INPUT_PROMPT.getText());
    }

    @ParameterizedTest
    @DisplayName("방문 일자 입력받기2")
    @ValueSource(strings = {"1", "2", "31"})
    void readVisitDate2(String input) {
        input(input);
        int inputDay = inputView.readVisitDate();

        assertThat(inputDay)
                .isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @DisplayName("방문 일자 입력받기3")
    @ValueSource(strings = {",", "  "})
    void readVisitDate3(String input) throws NoSuchElementException {
        input(input);

        assertThatThrownBy(() -> inputView.readVisitDate())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ArgumentException.INVALID_DATE.exception().getMessage());
    }

    @ParameterizedTest
    @DisplayName("메뉴와 개수 입력받기1")
    @ValueSource(strings = {"해산물파스타-2,레드와인-1,초코케이크-1"})
    void readMenuAndCount(String input) {
        input(input);
        inputView.readMenuAndCount();

        assertThat(getOutput())
                .contains(MENU_AND_COUNT_INPUT_PROMPT.getText());
    }

    @ParameterizedTest
    @DisplayName("메뉴와 개수 입력받기2")
    @ValueSource(strings = {"해산물파스타-2,레드와인-1,초코케이크-1"})
    void readMenuAndCount2(String input) {
        input(input);
        String inputMenuAndCount = inputView.readMenuAndCount();

        assertThat(inputMenuAndCount)
                .isEqualTo(input);
    }

    @Test
    @DisplayName("이벤트 혜택 미리보기 메시지 출력")
    void printEventBenefitPreview() {
        outputView.printEventBenefitPreview();
        assertThat(getOutput())
                .contains(EVENT_BENEFIT_PREVIEW.getText());
    }

    @Test
    @DisplayName("주문 출력")
    void printOrder() {
        outputView.printOrderedMenu(orderDto);
        assertThat(getOutput())
                .contains(ORDERED_MENU_DTO_TEXT_COMPONENT
                );
    }

    @Test
    @DisplayName("할인 전 금액 출력")
    void printPreDiscountAmount() {
        outputView.printPreDiscountAmount(preDiscountAmountDto);
        assertThat(getOutput())
                .contains(PRE_DISCOUNT_AMOUNT_TEXT);
    }

    @Test
    @DisplayName("증정 메뉴 출력")
    void printGiveawayMenu() {
        outputView.printGiveawayMenu(giveawayMenuDto);
        assertThat(getOutput())
                .contains(GIVEAWAY_TEXT);
    }

    @Test
    @DisplayName("혜택 출력")
    void printBenefits() {
        outputView.printBenefits(benefitsDto);
        assertThat(getOutput())
                .contains(BENEFIT_TEXT);
    }

    @Test
    @DisplayName("총 혜택 금액 출력")
    void printTotalBenefitAmount() {
        outputView.printTotalBenefitAmount(totalBenefitAmountDto);
        assertThat(getOutput())
                .contains(TOTAL_BENEFIT_AMOUNT_TEXT);
    }

    @Test
    @DisplayName("할인 후 금액 출력")
    void printPostDiscountAmount() {
        outputView.printPostDiscountAmount(postDiscountAmountDto);
        assertThat(getOutput())
                .contains(POST_DISCOUNT_AMOUNT_COMPONENT);
    }

    @Test
    @DisplayName("이벤트 배지 출력")
    void printEventBadge() {
        outputView.printEventBadge(eventBadgeDto);
        assertThat(getOutput())
                .contains(BADGE_COMPONENT);
    }
}
