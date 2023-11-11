package christmas.constant;

public enum MaxRetry {
    COUNT(10);

    private final int value;

    MaxRetry(final int value) {
        this.value = value;
    }

    public boolean isUnder(final int count) {
        return this.value < count;
    }
}
