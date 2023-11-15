package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GiveawayMenuTest extends UnitTest implements UnitTestStub {
    @BeforeEach
    void setUp() {
        giveawayMenu = GiveawayMenu.from(BENEFITS);
    }

    @Test
    @DisplayName("GiveawayMenu 객체 생성")
    void from() {
        assertThat(giveawayMenu)
                .isInstanceOf(GiveawayMenu.class);
    }

    @Test
    @DisplayName("GiveawayMenu 객체 생성2")
    void from2() {
        assertThat(giveawayMenu.menuAndCount())
                .isEqualTo(EXPECTED_MENU_AND_COUNT);
    }
}