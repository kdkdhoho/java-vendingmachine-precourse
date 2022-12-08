package vendingmachine.domain;

import java.util.Collections;
import java.util.Map;

public class VendingMachine {
    private final Map<Coin, Integer> coins;

    public VendingMachine(int money) {
        coins = Coin.exchange(money);
    }

    public Map<Coin, Integer> getCoins() {
        return Collections.unmodifiableMap(coins);
    }
}
