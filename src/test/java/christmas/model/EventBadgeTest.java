package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventBadgeTest extends UnitTest implements UnitTestStub {
    @BeforeEach
    void setUp() {
        totalBenefitAmount = TOTAL_BENEFIT_AMOUNT;
    }

    @Test
    @DisplayName("EventBadge 객체 생성")
    void from() {
        eventBadge = EventBadge.from(TOTAL_BENEFIT_AMOUNT);
        assertThat(eventBadge)
                .isEqualTo(EVENT_BADGE);
    }
}