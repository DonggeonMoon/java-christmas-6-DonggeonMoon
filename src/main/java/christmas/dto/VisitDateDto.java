package christmas.dto;

import christmas.model.VisitDate;
import java.time.LocalDate;

public record VisitDateDto(LocalDate date) {
    public static VisitDateDto from(VisitDate visitDate) {
        return new VisitDateDto(visitDate.getDate());
    }

    public VisitDate toEntity() {
        return VisitDate.from(date);
    }
}
