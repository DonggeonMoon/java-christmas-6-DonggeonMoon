package christmas.constant.calendar;

import java.time.LocalDate;

public enum Period {
    CHRISTMAS_EVENT(
            LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 31)
    ),
    CHRISTMAS_D_DAY_EVENT(
            LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 25)
    );

    private final LocalDate startDate;
    private final LocalDate endDate;

    Period(final LocalDate startDate, final LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate generateDateFrom(final int inputDay) {
        return this.startDate.withDayOfMonth(inputDay);
    }

    public boolean notIncludes(final int day) {
        return !includes(day);
    }

    private boolean includes(final int day) {
        return equalsOrMore(day) && equalsOrLess(day);
    }

    private boolean equalsOrMore(final int day) {
        return day >= this.startDate.getDayOfMonth();
    }

    private boolean equalsOrLess(final int day) {
        return day <= this.endDate.getDayOfMonth();
    }
}
