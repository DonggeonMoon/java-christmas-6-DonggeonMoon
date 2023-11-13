package christmas.constant.validation;

import static christmas.constant.exception.ArgumentException.INVALID_MENU;

import java.util.Objects;
import java.util.function.Function;

public enum IntegerValidation {
    NOT_LESS_THAN_ONE(input -> input >= 1);

    private final Function<Integer, Boolean> condition;

    IntegerValidation(final Function<Integer, Boolean> condition) {
        this.condition = condition;
    }

    public void validate(final Integer input) {
        Objects.requireNonNull(input);

        if (this.isViolatedBy(input)) {
            throw INVALID_MENU.exception();
        }
    }

    private boolean isViolatedBy(final Integer input) {
        return !this.condition.apply(input);
    }
}
