package vendingmachine.domain;

import java.util.Map;

public class VendingMachine {
    private final Map<Coin, Integer> coins;

    public VendingMachine(int money) {
        coins = Coin.exchange(money);
    }
}
