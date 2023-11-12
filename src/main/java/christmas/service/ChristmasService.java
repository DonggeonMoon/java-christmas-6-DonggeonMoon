package christmas.service;

import christmas.dto.VisitDateDto;
import christmas.model.OrderedMenu;
import christmas.model.VisitDate;

public class ChristmasService {
    private ChristmasService() {
    }

    public static ChristmasService create() {
        return new ChristmasService();
    }

    public VisitDateDto generateVisitDate(int inputDay) {
        VisitDate visitDate = VisitDate.from(inputDay);
        return VisitDateDto.from(visitDate);
    }

    public void generateOrderedMenu(String inputMenuAndCount) {
        OrderedMenu orderedMenu = OrderedMenu.from(inputMenuAndCount);
    }
}
