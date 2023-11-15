package christmas.template;

import christmas.dto.BenefitsDto;
import christmas.dto.EventBadgeDto;
import christmas.dto.GiveawayMenuDto;
import christmas.dto.OrderDto;
import christmas.dto.PostDiscountAmountDto;
import christmas.dto.PreDiscountAmountDto;
import christmas.dto.TotalBenefitAmountDto;
import christmas.dto.VisitDateDto;
import christmas.model.Benefits;
import christmas.model.EventBadge;
import christmas.model.GiveawayMenu;
import christmas.model.Order;
import christmas.model.PostDiscountAmount;
import christmas.model.PreDiscountAmount;
import christmas.model.TotalBenefitAmount;
import christmas.model.VisitDate;
import christmas.service.ChristmasService;
import christmas.view.ChristmasInputView;
import christmas.view.ChristmasOutputView;

public abstract class UnitTest {
    protected VisitDate visitDate;
    protected Order order;
    protected Benefits benefits;
    protected GiveawayMenu giveawayMenu;
    protected PreDiscountAmount preDiscountAmount;
    protected TotalBenefitAmount totalBenefitAmount;
    protected PostDiscountAmount postDiscountAmount;
    protected EventBadge eventBadge;
    protected VisitDateDto visitDateDto;
    protected OrderDto orderDto;
    protected BenefitsDto benefitsDto;
    protected GiveawayMenuDto giveawayMenuDto;
    protected PreDiscountAmountDto preDiscountAmountDto;
    protected TotalBenefitAmountDto totalBenefitAmountDto;
    protected PostDiscountAmountDto postDiscountAmountDto;
    protected EventBadgeDto eventBadgeDto;
    protected ChristmasService service;
    protected ChristmasInputView inputView;
    protected ChristmasOutputView outputView;
}
