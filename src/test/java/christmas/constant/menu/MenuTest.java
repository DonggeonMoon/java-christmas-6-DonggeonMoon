package christmas.constant.menu;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.stub.UnitTestStub;
import christmas.template.UnitTest;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

class MenuTest extends UnitTest implements UnitTestStub {
    @ParameterizedTest
    @DisplayName("Menu 객체 생성")
    @EnumSource(Menu.class)
    void from(Menu menu) {
        assertThat(menu)
                .isInstanceOf(Menu.class);
    }

    @ParameterizedTest
    @DisplayName("MainMenu 여부 검증")
    @EnumSource(value = Menu.class, names = {"BARBEQUE_RIB", "SEAFOOD_PASTA", "CHRISTMAS_PASTA"})
    void isMainMenu(Menu menu) {
        assertThat(menu.isMainMenu())
                .isTrue();
    }

    @ParameterizedTest
    @DisplayName("Dessert 여부 검증")
    @EnumSource(value = Menu.class, names = {"CHOCOLATE_CAKE", "ICE_CREAM"})
    void isDessert(Menu menu) {
        assertThat(menu.isDessert())
                .isTrue();
    }

    @ParameterizedTest
    @DisplayName("Drink 아닌지 여부 검증")
    @EnumSource(
            value = Menu.class,
            names = {
                    "MUSHROOM_SOUP",
                    "TAPAS",
                    "CAESAR_SALAD",
                    "T_BONE_STEAK",
                    "BARBEQUE_RIB",
                    "SEAFOOD_PASTA",
                    "CHRISTMAS_PASTA",
                    "ZERO_COKE",
                    "RED_WINE",
                    "CHAMPAGNE",
                    "NOTHING"
            })
    void isNotDrink(Menu menu) {
        assertThat(menu.isDessert())
                .isFalse();
    }

    @ParameterizedTest
    @DisplayName("Menu 이름 가져오기")
    @CsvSource({
            "MUSHROOM_SOUP, 양송이수프",
            "TAPAS, 타파스",
            "CAESAR_SALAD, 시저 샐러드",
            "T_BONE_STEAK, 티본스테이크",
            "BARBEQUE_RIB, 바비큐립",
            "SEAFOOD_PASTA, 해산물파스타",
            "CHRISTMAS_PASTA, 크리스마스파스타",
            "CHOCOLATE_CAKE, 초코케이크",
            "ICE_CREAM, 아이스크림",
            "ZERO_COKE, 제로콜라",
            "RED_WINE, 레드와인",
            "CHAMPAGNE, 샴페인",
            "NOTHING, 없음"
    })
    void getName(Menu menu, String name) {
        assertThat(menu.getName())
                .isEqualTo(name);
    }

    @ParameterizedTest
    @DisplayName("Menu 가격 가져오기")
    @CsvSource({
            "MUSHROOM_SOUP, 6000",
            "TAPAS, 5500",
            "CAESAR_SALAD, 8000",
            "T_BONE_STEAK, 55000",
            "BARBEQUE_RIB, 54000",
            "SEAFOOD_PASTA, 35000",
            "CHRISTMAS_PASTA, 25000",
            "CHOCOLATE_CAKE, 15000",
            "ICE_CREAM, 5000",
            "ZERO_COKE, 3000",
            "RED_WINE, 60000",
            "CHAMPAGNE, 25000",
            "NOTHING, 0"
    })
    void getPrice(Menu menu, BigDecimal price) {
        assertThat(menu.getPrice())
                .isEqualTo(price);
    }
}