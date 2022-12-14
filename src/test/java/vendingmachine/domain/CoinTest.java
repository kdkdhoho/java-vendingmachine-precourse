package vendingmachine.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

class CoinTest {

    @DisplayName("투입 금액에 따른 동전 반환 테스트")
    @Test
    void change() {
        int money = 550;

        Map<Coin, Integer> result = Coin.change(money);

        int sum = 0;
        for (Map.Entry<Coin, Integer> entry : result.entrySet()) {
            sum += entry.getKey().getAmount() * entry.getValue();
        }

        Assertions.assertThat(money).isEqualTo(sum);
    }
}