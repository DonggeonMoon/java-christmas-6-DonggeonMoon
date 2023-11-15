package christmas.model;

import static christmas.constant.exception.ArgumentException.INVALID_ORDER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderTest extends UnitTest implements UnitTestStub {
    @BeforeEach
    void setUp() {
        order = Order.from(VALID_INPUT);
    }

    @Test
    @DisplayName("Order 객체 생성")
    void from() {
        assertThat(order)
                .isInstanceOf(Order.class);

    }

    @Test
    @DisplayName("Order 객체 생성2")
    void from2() {
        assertThat(order.menuAndCount())
                .isEqualTo(MENU_AND_COUNT);
    }

    @ParameterizedTest
    @DisplayName("Order 객체 생성3")
    @ValueSource(strings = {
            "해산물파스타-1,레드와인-1,초코케이크-0",
            "해산물파스타-1,레드와인-0,초코케이크-1",
            "해산물파스타-0,레드와인-1,초코케이크-0",
            "알리오올리오-1,레드와인-1,초코케이크-1",
            "해산물파스타-2,화이트와인-1,초코케이크-2",
            "해산물파스타-3,화이트와인-1,초코케이크-1",
            "해산물파스타3,레드와인-1,초코케이크-1",
            "해산물파스타-3레드와인-1,초코케이크1",
            "해산물파스타3,레드와인-1초코케이크1",
            "해산물파스타-3,해산물파스타-1,초코케이크1",
            "해산물파스타3,해산물파스타-3-1,초코케이크1",
            "레드와인-1",
            "해산물파스타-13,해산물파스타-6,초코케이크-2",
            "해산물파스타-13,레드와인-6,초코케이크-2"
    })
    void from3(String invalidInput) {
        assertThatThrownBy(() -> Order.from(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_ORDER.exception().getMessage());
    }

    @Test
    @DisplayName("Order 객체 생성4")
    void from4() {
        assertThat(Order.from(MENU_AND_COUNT))
                .isInstanceOf(Order.class);
    }

    @Test
    @DisplayName("PreDiscountAmount 계산 후 반환")
    void calculatePreDiscountAmount() {
        assertThat(order.calculatePreDiscountAmount())
                .isEqualTo(PRE_DISCOUNT_AMOUNT2);
    }
}