package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class MoneyTest {

    @DisplayName("Money 객체 생성자 테스트 - 실패")
    @ParameterizedTest
    @ValueSource(ints = {-1, 9, 99})
    void Money_fail(int money) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Money(money);
        });
    }

    @DisplayName("Money 객체 생성자 테스트 - 성공")
    @ParameterizedTest
    @ValueSource(ints = {0, 10, 100, 450})
    void Money(int money) {
        assertThatNoException().isThrownBy(() -> {
            new Money(money);
        });
    }
}