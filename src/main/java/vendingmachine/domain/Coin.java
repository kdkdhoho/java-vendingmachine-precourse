package vendingmachine.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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

    public static Map<Coin, Integer> change(int money) {
        Map<Coin, Integer> result = new HashMap<>();

        while (money > 0) {
            Coin randomCoin = pickRandomCoin();
            if (money >= randomCoin.amount) {
                result.put(randomCoin, result.getOrDefault(randomCoin, 0) + 1);
                money -= randomCoin.amount;
            }
        }
        return result;
    }

    private static Coin pickRandomCoin() {
        List<Coin> coins = Arrays.asList(Coin.values());
        Collections.shuffle(coins);
        return coins.get(0);
    }
}
