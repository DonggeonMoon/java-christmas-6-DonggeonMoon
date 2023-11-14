package christmas.model;

import static christmas.constant.calendar.DayCategory.WEEKDAYS;
import static christmas.constant.calendar.DayCategory.WEEKEND;
import static christmas.constant.calendar.Period.CHRISTMAS_EVENT;
import static christmas.constant.exception.ArgumentException.INVALID_DATE;

import christmas.constant.calendar.Date;
import java.math.BigDecimal;
import java.time.DayOfWeek;
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

    public int calculateDayOfMonth() {
        return date.getDayOfMonth();
    }

    public BigDecimal calculateDayOfMonthInBigDecimal() {
        return BigDecimal.valueOf(calculateDayOfMonth());
    }

    public boolean isWeekDay() {
        return WEEKDAYS.includes(calculateDayOfWeek());
    }

    public boolean isWeekend() {
        return WEEKEND.includes(calculateDayOfWeek());
    }

    private DayOfWeek calculateDayOfWeek() {
        return date.getDayOfWeek();
    }

    public boolean isNotStarredDate() {
        return !isStarredDate();
    }

    private boolean isStarredDate() {
        return Date.STARRED
                .includes(date);
    }
}
