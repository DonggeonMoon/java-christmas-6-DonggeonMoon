package christmas.constant;

public enum Message {
    EVENT_PLANNER("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    VISIT_DATE_INPUT_PROMPT("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    private final String text;

    Message(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
