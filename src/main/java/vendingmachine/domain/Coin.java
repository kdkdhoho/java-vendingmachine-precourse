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

    private final static int FIRST = 0;
    private final static int DEFAULT = 0;

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    // TODO: 코드 개선
    public static Map<Coin, Integer> changeToCoins(Money money) {
        Map<Coin, Integer> result = new HashMap<>();
        List<Coin> coins = Arrays.asList(Coin.values());
        while (money.isMoreThanZero()) {
            Coin randomCoin = shuffleAndGetFirst(coins);
            if (money.isBiggerOrEqualThan(randomCoin.amount)) {
                result.put(randomCoin, result.getOrDefault(randomCoin, DEFAULT) + 1);
                money = money.subtract(randomCoin.amount);
            }
        }
        return result;
    }

    private static Coin shuffleAndGetFirst(List<Coin> coins) {
        Collections.shuffle(coins);
        return coins.get(FIRST);
    }
}
