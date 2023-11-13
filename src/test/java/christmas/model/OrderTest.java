package christmas.model;

import static christmas.constant.exception.ArgumentException.INVALID_MENU;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.constant.menu.MenuCategory.Menu;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderTest {
    private static final String validInput = "해산물파스타-2,레드와인-1,초코케이크-1";
    private Order order;
    private Map<Menu, Integer> menuAndCount;

    @BeforeEach
    void setUp() {
        menuAndCount = Map.of(Menu.SEAFOOD_PASTA, 2, Menu.RED_WINE, 1, Menu.CHOCOLATE_CAKE, 1);
    }

    @Test
    void from() {
        order = Order.from(validInput);

        assertThat(order)
                .isInstanceOf(Order.class);

    }

    @Test
    void from2() {
        order = Order.from(validInput);

        assertThat(order.menuAndCount())
                .isEqualTo(menuAndCount);
    }

    @ParameterizedTest
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
            "해산물파스타-13,해산물파스타-6,초코케이크-2"
    })
    void from3(String invalidInput) {
        assertThatThrownBy(() -> Order.from(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_MENU.exception().getMessage());
    }
}