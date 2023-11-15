package christmas.dto;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.model.VisitDate;
import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VisitDateDtoTest extends UnitTest implements UnitTestStub {
    @BeforeEach
    void setUp() {
        visitDateDto = VisitDateDto.from(VISIT_DATE);
    }

    @Test
    @DisplayName("VisitDateDto 객체 생성")
    void from() {
        assertThat(visitDateDto)
                .isInstanceOf(VisitDateDto.class);
    }

    @Test
    @DisplayName("모델로 변환")
    void toModel() {
        assertThat(visitDateDto.toModel())
                .isInstanceOf(VisitDate.class);
    }
}