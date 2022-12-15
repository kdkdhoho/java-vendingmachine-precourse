package vendingmachine.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Coins {
    private final Map<Coin, Integer> coins;

    public Coins(Map<Coin, Integer> coins) {
        this.coins = coins;
    }

    public Map<Coin, Integer> getCoins() {
        return Collections.unmodifiableMap(coins);
    }

    public int calculateTotalAmount() {
        int result = 0;

        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            result += entry.getKey().getAmount() * entry.getValue();
        }
        return result;
    }

    public boolean isLowerOrEqualThan(int value) {
        int totalAmount = calculateTotalAmount();
        return totalAmount <= value;
    }

    public Map<Coin, Integer> change(int targetMoney) {
        Map<Coin, Integer> result = new HashMap<>();
        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            Coin coin = entry.getKey();
            while (entry.getValue() > 0 && targetMoney >= coin.getAmount()) {
                result.put(coin, result.getOrDefault(coin, 0) + 1);
                targetMoney -= coin.getAmount();
                coins.put(coin, coins.get(coin) - 1);
            }
        }
        return result;
    }
}
