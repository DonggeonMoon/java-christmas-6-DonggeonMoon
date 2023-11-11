package christmas.service;

import christmas.model.VisitDate;

public class ChristmasService {
    private ChristmasService() {
    }

    public static ChristmasService create() {
        return new ChristmasService();
    }

    public void generateVisitDate(int inputDay) {
        VisitDate.from(inputDay);
    }
}
