package christmas.constant.calendar;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Objects;

public enum DayCategory {
    WEEKDAYS(
            List.of(
                    DayOfWeek.SUNDAY,
                    DayOfWeek.MONDAY,
                    DayOfWeek.TUESDAY,
                    DayOfWeek.WEDNESDAY,
                    DayOfWeek.THURSDAY
            )),
    WEEKEND(
            List.of(
                    DayOfWeek.FRIDAY,
                    DayOfWeek.SATURDAY
            )
    );

    private final List<DayOfWeek> dayOfWeeks;

    DayCategory(final List<DayOfWeek> dayOfWeeks) {
        this.dayOfWeeks = dayOfWeeks;
    }

    public boolean includes(final DayOfWeek dayOfWeek) {
        Objects.requireNonNull(dayOfWeek);

        return this.dayOfWeeks.stream()
                .anyMatch(dayOfWeekInInteger -> dayOfWeekInInteger.equals(dayOfWeek));
    }
}
