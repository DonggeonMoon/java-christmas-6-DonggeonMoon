package christmas.model;

import static christmas.constant.calendar.Date.STARRED_DATE;
import static christmas.constant.calendar.DayCategory.WEEKDAYS;
import static christmas.constant.calendar.DayCategory.WEEKEND;
import static christmas.constant.calendar.Period.CHRISTMAS_EVENT;
import static christmas.constant.exception.ArgumentException.INVALID_DATE;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public record VisitDate(
        LocalDate date
) {
    public static VisitDate from(final LocalDate date) {
        Objects.requireNonNull(date);

        return new VisitDate(date);
    }

    public static VisitDate from(final int inputDay) {
        validatePeriod(inputDay);
        return new VisitDate(CHRISTMAS_EVENT.generateDateFrom(inputDay));
    }

    private static void validatePeriod(final int inputDay) {
        if (CHRISTMAS_EVENT.notIncludes(inputDay)) {
            throw INVALID_DATE.exception();
        }
    }

    public int getDayOfMonth() {
        return date.getDayOfMonth();
    }

    public BigDecimal getDayOfMonthInBigDecimal() {
        return BigDecimal.valueOf(date.getDayOfMonth());
    }

    public boolean isWeekDay() {
        return WEEKDAYS.includes(date.getDayOfWeek());
    }

    public boolean isWeekend() {
        return WEEKEND.includes(date.getDayOfWeek());
    }

    public boolean isStarredDate() {
        return STARRED_DATE.includes(date);
    }
}
