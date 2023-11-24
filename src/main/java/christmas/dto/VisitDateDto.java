package christmas.dto;

import christmas.model.VisitDate;
import java.time.LocalDate;
import java.util.Objects;

public record VisitDateDto(LocalDate date) {
    public static VisitDateDto from(final VisitDate visitDate) {
        Objects.requireNonNull(visitDate);

        return new VisitDateDto(visitDate.date());
    }

    public VisitDate toModel() {
        return VisitDate.from(date);
    }
}
