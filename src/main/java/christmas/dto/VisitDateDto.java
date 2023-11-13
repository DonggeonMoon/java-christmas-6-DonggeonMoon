package christmas.dto;

import christmas.model.VisitDate;
import java.time.LocalDate;

public record VisitDateDto(LocalDate date) {
    public static VisitDateDto from(final VisitDate visitDate) {
        return new VisitDateDto(visitDate.date());
    }

    public VisitDate toModel() {
        return VisitDate.from(date);
    }
}
