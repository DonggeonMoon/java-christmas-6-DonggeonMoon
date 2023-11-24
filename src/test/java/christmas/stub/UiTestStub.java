package christmas.stub;

import static christmas.constant.string.Message.BADGE_PREFIX;
import static christmas.constant.string.Message.ORDERED_MENU_PREFIX;

import christmas.model.VisitDate;
import java.time.LocalDate;
import java.util.List;

public interface UiTestStub {
    VisitDate VISIT_DATE = VisitDate.from(LocalDate.of(2023, 12, 3));
    String validInput = "해산물파스타-2,레드와인-1,초코케이크-1";
    List<String> ORDERED_MENU_DTO_TEXT_COMPONENT =
            List.of(
                    ORDERED_MENU_PREFIX.getText(),
                    "레드와인 1개",
                    "해산물파스타 2개",
                    "초코케이크 1개"
            );
    String PRE_DISCOUNT_AMOUNT_TEXT = "145,000원";
    String GIVEAWAY_TEXT = "샴페인 1개";
    String[] BENEFIT_TEXT = {
            "평일 할인 2,023원",
            "특별 할인 1,000원",
            "증정 이벤트 25,000원"};
    String TOTAL_BENEFIT_AMOUNT_TEXT = "-29,223원";
    List<String> POST_DISCOUNT_AMOUNT_COMPONENT = List.of(
            "<할인 후 예상 결제 금액>",
            "115,777원"
    );
    List<String> BADGE_COMPONENT = List.of(
            BADGE_PREFIX.getText(),
            "산타"
    );

}
