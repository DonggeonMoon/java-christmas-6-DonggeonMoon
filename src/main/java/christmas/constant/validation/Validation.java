package christmas.constant.validation;

import static christmas.constant.exception.ArgumentException.INVALID_DATE;

import java.util.function.Function;
import java.util.regex.Pattern;

public enum Validation {
    NUMBER_RULE((input) -> Pattern.compile("^[1-9]*$").matcher(input).matches());

    private final Function<String, Boolean> condition;

    Validation(final Function<String, Boolean> condition) {
        this.condition = condition;
    }

    public void validate(final String inputDay) {
        if (this.isViolatedBy(inputDay)) {
            throw INVALID_DATE.exception();
        }
    }

    private boolean isViolatedBy(String input) {
        return !this.condition.apply(input);
    }
}
