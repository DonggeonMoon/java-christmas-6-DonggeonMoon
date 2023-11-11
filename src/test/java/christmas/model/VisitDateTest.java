package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class VisitDateTest {
    private VisitDate visitDate;

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 15, 31})
    void from(int inputDay) {
        visitDate = VisitDate.from(inputDay);

        assertThat(visitDate)
                .isInstanceOf(VisitDate.class);
    }

}