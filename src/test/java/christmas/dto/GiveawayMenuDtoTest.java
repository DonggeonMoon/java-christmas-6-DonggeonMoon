package christmas.dto;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GiveawayMenuDtoTest extends UnitTest implements UnitTestStub {
    @BeforeEach
    void setUp() {
        giveawayMenuDto = GiveawayMenuDto.from(GIVEAWAY_MENU);
    }

    @Test
    @DisplayName("GiveawayMenuDto 객체 생성")
    void from() {
        assertThat(giveawayMenuDto)
                .isInstanceOf(GiveawayMenuDto.class);
    }

    @Test
    @DisplayName("출력 메시지 생성")
    void testToString() {
        assertThat(giveawayMenuDto.toString())
                .contains(GIVEAWAY_DTO_MESSAGE);
    }
}