package christmas.constant;

import java.util.Arrays;
import java.util.List;

public enum Delimiter {
    COMMA(","),
    DASH("-");

    private final String character;

    Delimiter(final String character) {
        this.character = character;
    }

    public List<String> split(String input) {
        return Arrays.stream(input.split(this.character))
                .map(String::trim)
                .toList();
    }
}