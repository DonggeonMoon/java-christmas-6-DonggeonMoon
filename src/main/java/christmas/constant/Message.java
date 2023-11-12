package christmas.constant;

public enum Message {
    EVENT_PLANNER("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    VISIT_DATE_INPUT_PROMPT("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    MENU_AND_COUNT_INPUT_PROMPT("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    EVENT_BENEFIT_PREVIEW("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDERED_MENU_PREFIX("<주문 메뉴>"),
    PRE_DISCOUNT_AMOUNT_PREFIX("<할인 전 총주문 금액>"),
    GIVEAWAY_PREFIX("<증정 메뉴>"),
    BENEFIT_PREFIX("<혜택 내역>"),
    TOTAL_BENEFIT_AMOUNT_PREFIX("<총혜택 금액>");
    private final String text;

    Message(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
