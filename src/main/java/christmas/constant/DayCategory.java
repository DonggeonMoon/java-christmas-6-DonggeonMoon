package christmas.constant;

import java.time.DayOfWeek;
import java.util.List;

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
                    DayOfWeek.SUNDAY,
                    DayOfWeek.SATURDAY
            )
    );

    private final List<DayOfWeek> dayOfWeeks;

    DayCategory(final List<DayOfWeek> dayOfWeeks) {
        this.dayOfWeeks = dayOfWeeks;
    }

    public boolean includes(DayOfWeek dayOfWeek) {
        return WEEKDAYS.dayOfWeeks.stream()
                .anyMatch(i -> i.equals(dayOfWeek));
    }
}
