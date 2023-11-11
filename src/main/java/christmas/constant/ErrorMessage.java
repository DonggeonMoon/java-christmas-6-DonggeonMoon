package christmas.constant;

public enum ErrorMessage {
    EXCEEDING_MAX_RETRY("최대 재시도 횟수를 초과하였습니다.");

    private static final String PREFIX = "[ERROR]";
    private final String text;

    ErrorMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return PREFIX + text;
    }
}
