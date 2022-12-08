package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static Map<Coin, Integer> exchange(int money) {
        Map<Coin, Integer> result = new HashMap<>();

        Coin[] coins = Coin.values();
        for (Coin coin : coins) {
            result.put(coin, money / coin.getAmount());
            money %= coin.getAmount();
        }

        return result;
    }
}
