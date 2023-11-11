package christmas.constant.exception;

public enum ArgumentException {
    EXCEEDING_MAX_RETRY("최대 재시도 횟수를 초과하였습니다."),
    INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private static final String PREFIX = "[ERROR] ";
    private final String text;

    ArgumentException(String text) {
        this.text = text;
    }


    public IllegalArgumentException exception() {
        return new IllegalArgumentException(PREFIX + text);
    }
}
