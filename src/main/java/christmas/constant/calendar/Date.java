package christmas.constant.calendar;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public enum Date {
    STARRED(
            List.of(
                    LocalDate.of(2023, 12, 3),
                    LocalDate.of(2023, 12, 10),
                    LocalDate.of(2023, 12, 17),
                    LocalDate.of(2023, 12, 24),
                    LocalDate.of(2023, 12, 25),
                    LocalDate.of(2023, 12, 31)
            )
    );

    private final List<LocalDate> dates;

    Date(final List<LocalDate> dates) {
        this.dates = dates;
    }

    public boolean includes(final LocalDate date) {
        Objects.requireNonNull(date);

        return STARRED.dates
                .stream()
                .anyMatch(starredDay -> starredDay.equals(date));
    }
}
