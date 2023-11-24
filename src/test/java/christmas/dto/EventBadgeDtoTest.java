package christmas.dto;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.constant.badge.Badge;
import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventBadgeDtoTest extends UnitTest implements UnitTestStub {
    @BeforeEach
    void setUp() {
        eventBadgeDto = EventBadgeDto.from(EVENT_BADGE);
    }

    @Test
    @DisplayName("EventBadgeDto 객체 생성")
    void from() {
        assertThat(eventBadgeDto)
                .isInstanceOf(EventBadgeDto.class);
    }

    @Test
    @DisplayName("EventBadgeDto 객체 생성2")
    void from2() {
        assertThat(EventBadgeDto.from(Badge.SANTA))
                .isEqualTo(EVENT_BADGE_DTO);
    }

    @Test
    @DisplayName("출력 메시지 생성")
    void testToString() {
        assertThat(eventBadgeDto.toString())
                .contains(EXPECTED_BADGE_NAME);
    }
}