package christmas.model;

import static christmas.constant.exception.ArgumentException.INVALID_DATE;

import christmas.constant.Period;
import java.time.LocalDate;

public class VisitDate {
    private final LocalDate date;

    private VisitDate(final LocalDate date) {
        this.date = date;
    }

    public static VisitDate from(final int inputDate) {
        validatePeriod(inputDate);
        return new VisitDate(
                Period.CHRISTMAS_EVENT
                        .generateDateFrom(inputDate)
        );
    }

    private static void validatePeriod(final int inputDay) {
        if (Period.CHRISTMAS_EVENT.notCovers(inputDay)) {
            throw INVALID_DATE.exception();
        }
    }

    public LocalDate getDate() {
        return date;
    }
}
