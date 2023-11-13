package christmas.constant.number;

public enum Count {
    ONE(1);

    private final Integer value;

    Count(final Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
