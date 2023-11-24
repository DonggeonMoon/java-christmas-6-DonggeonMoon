package christmas.controller;

import christmas.constant.exception.StateException;
import christmas.constant.number.MaxRetry;
import java.util.function.Supplier;

public abstract class AbstractRetry {
    protected final <T> T run(final Supplier<T> supplier) {
        int retryCount = 0;
        while (MaxRetry.COUNT.isUnder(retryCount)) {
            try {
                return supplier.get();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            retryCount++;
        }
        throw StateException.EXCEEDING_MAX_RETRY.exception();
    }
}
