package vendingmachine.domain;

import java.util.Collections;
import java.util.Map;

public class Coins {
    private final Map<Coin, Integer> coins;

    public Coins(Money money) {
        this.coins = Coin.changeToCoins(money);
    }

    public int getTotalAmount() {
        int result = 0;
        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            result += entry.getKey().getAmount() * entry.getValue();
        }
        return result;
    }

    public Map<Coin, Integer> getCoins() {
        return Collections.unmodifiableMap(coins);
    }
}
