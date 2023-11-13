package christmas.constant.calendar;

import java.time.LocalDate;

public enum Period {
    CHRISTMAS_EVENT(
            LocalDate.of(2023, 12, 1),
            LocalDate.of(2023, 12, 31)
    ),
    CHRISTMAS_D_Day_Event(
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

    public boolean includes(final int day) {
        return (isOver(day) && isUnder(day));
    }

    public boolean notIncludes(final int day) {
        return !includes(day);
    }

    private boolean isOver(final int day) {
        return day >= this.startDate.getDayOfMonth();
    }

    private boolean isUnder(final int day) {
        return day <= this.endDate.getDayOfMonth();
    }
}
