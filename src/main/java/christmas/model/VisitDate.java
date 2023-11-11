package christmas.model;

import christmas.constant.Period;
import java.time.LocalDate;

public class VisitDate {
    private final LocalDate date;

    private VisitDate(final LocalDate date) {
        this.date = date;
    }

    public static VisitDate from(final int inputDate) {
        return new VisitDate(
                Period.CHRISTMAS_EVENT
                        .generateDateFrom(inputDate)
        );
    }
}
