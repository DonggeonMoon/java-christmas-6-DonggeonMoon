package christmas.service;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.dto.VisitDateDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ChristmasServiceTest {
    private ChristmasService service;

    @BeforeEach
    void setUp() {
        service = ChristmasService.create();
    }

    @Test
    void create() {
        assertThat(service)
                .isInstanceOf(ChristmasService.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 31})
    void generateVisitDateFrom(int inputDay) {
        assertThat(service.generateVisitDateFrom(inputDay))
                .isInstanceOf(VisitDateDto.class);
    }
}