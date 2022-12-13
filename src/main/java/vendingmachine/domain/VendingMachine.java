package vendingmachine.domain;

import java.util.List;
import java.util.Map;

public class VendingMachine {
    private final Coins coins;
    private Items items;

    public VendingMachine(Coins coins) {
        this.coins = coins;
    }

    public Map<Coin, Integer> getCoins() {
        return coins.getCoins();
    }

    public void initItems(List<Item> items) {
        this.items = new Items(items);
    }
}