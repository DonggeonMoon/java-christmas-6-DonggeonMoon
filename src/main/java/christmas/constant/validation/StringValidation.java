package christmas.constant.validation;

import static christmas.constant.exception.ArgumentException.INVALID_DATE;

import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Pattern;

public enum StringValidation {
    NUMBER_RULE((String input) -> {
        Objects.requireNonNull(input);
        return Pattern.compile("^[1-9]*$").matcher(input).matches();
    }),
    NOT_EMPTY_RULE(input -> {
        Objects.requireNonNull(input);
        return !input.isEmpty();
    });

    private final Function<String, Boolean> condition;

    StringValidation(final Function<String, Boolean> condition) {
        this.condition = condition;
    }

    public void validate(final String input) {
        if (this.isViolatedBy(input)) {
            throw INVALID_DATE.exception();
        }
    }

    private boolean isViolatedBy(final String input) {
        return !this.condition.apply(input);
    }
}
