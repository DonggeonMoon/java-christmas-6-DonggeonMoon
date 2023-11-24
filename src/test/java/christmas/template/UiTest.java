package christmas.template;

import camp.nextstep.edu.missionutils.Console;
import christmas.dto.BenefitsDto;
import christmas.dto.EventBadgeDto;
import christmas.dto.GiveawayMenuDto;
import christmas.dto.OrderDto;
import christmas.dto.PostDiscountAmountDto;
import christmas.dto.PreDiscountAmountDto;
import christmas.dto.TotalBenefitAmountDto;
import christmas.model.Benefits;
import christmas.model.EventBadge;
import christmas.model.GiveawayMenu;
import christmas.model.Order;
import christmas.model.PostDiscountAmount;
import christmas.model.PreDiscountAmount;
import christmas.model.TotalBenefitAmount;
import christmas.view.ChristmasInputView;
import christmas.view.ChristmasOutputView;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class UiTest {
    protected Order order;
    protected Benefits benefits;
    protected GiveawayMenu giveawayMenu;
    protected PreDiscountAmount preDiscountAmount;
    protected TotalBenefitAmount totalBenefitAmount;
    protected PostDiscountAmount postDiscountAmount;
    protected EventBadge eventBadge;
    protected OrderDto orderDto;
    protected BenefitsDto benefitsDto;
    protected GiveawayMenuDto giveawayMenuDto;
    protected PreDiscountAmountDto preDiscountAmountDto;
    protected TotalBenefitAmountDto totalBenefitAmountDto;
    protected PostDiscountAmountDto postDiscountAmountDto;
    protected EventBadgeDto eventBadgeDto;
    protected ChristmasInputView inputView;
    protected ChristmasOutputView outputView;
    protected PrintStream systemOut;
    protected OutputStream captor;

    @BeforeEach
    protected void init() {
        systemOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    protected final String getOutput() {
        return captor.toString().trim();
    }

    protected void input(final String... arguments) {
        final byte[] bytes = String.join("\n", arguments).getBytes();
        System.setIn(new ByteArrayInputStream(bytes));
    }

    @AfterEach
    protected void cleanUp() {
        System.setOut(systemOut);
        System.out.println(captor);
        Console.close();
    }

}
