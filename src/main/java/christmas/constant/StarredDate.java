package christmas.constant;

import java.time.LocalDate;
import java.util.List;

public enum StarredDate {
    STARRED_DATE(
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

    StarredDate(final List<LocalDate> dates) {
        this.dates = dates;
    }

    public boolean includes(final LocalDate date) {
        return STARRED_DATE.dates
                .stream()
                .anyMatch(starredDay -> starredDay.equals(date));
    }
}
