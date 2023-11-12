package christmas.model;

import static christmas.constant.DayCategory.WEEKDAYS;
import static christmas.constant.DayCategory.WEEKEND;
import static christmas.constant.exception.ArgumentException.INVALID_DATE;

import christmas.constant.Period;
import christmas.constant.StarredDate;
import java.time.LocalDate;

public class VisitDate {
    private final LocalDate date;

    private VisitDate(final LocalDate date) {
        this.date = date;
    }

    public static VisitDate from(final LocalDate date) {
        return new VisitDate(date);
    }

    public static VisitDate from(final int inputDate) {
        validatePeriod(inputDate);
        return new VisitDate(
                Period.CHRISTMAS_EVENT
                        .generateDateFrom(inputDate)
        );
    }

    private static void validatePeriod(final int inputDay) {
        if (Period.CHRISTMAS_EVENT.notIncludes(inputDay)) {
            throw INVALID_DATE.exception();
        }
    }

    public int getDayOfMonth() {
        return date.getDayOfMonth();
    }

    public boolean isWeekDay() {
        return WEEKDAYS.includes(date.getDayOfWeek());
    }

    public boolean isWeekend() {
        return WEEKEND.includes(date.getDayOfWeek());
    }

    public boolean isStarredDate() {
        return StarredDate.STARRED_DATE.includes(date);
    }

    public LocalDate getDate() {
        return date;
    }
}
