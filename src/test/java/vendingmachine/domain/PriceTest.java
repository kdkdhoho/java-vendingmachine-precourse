package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class PriceTest {

    @DisplayName("유효성 검사 테스트 - 실패")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 9, 99})
    void Price_fail(int price) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Price(price);
        });
    }
    @DisplayName("유효성 검사 테스트 - 성공")
    @ParameterizedTest
    @ValueSource(ints = {100, 150, 450})
    void Price(int price) {
        assertThatNoException().isThrownBy(() -> {
            new Price(price);
        });
    }
}