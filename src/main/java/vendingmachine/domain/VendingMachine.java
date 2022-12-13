package vendingmachine.domain;

import java.util.List;
import java.util.Map;

public class VendingMachine {
    private Coins coins;
    private Items items;
    private Money consumerMoney;

    public void initCoins(Coins coins) {
        this.coins = coins;
    }

    public Map<Coin, Integer> getCoins() {
        return coins.getCoins();
    }

    public void initItems(List<Item> items) {
        this.items = new Items(items);
    }

    public void initConsumerMoney(Money consumerMoney) {
        this.consumerMoney = consumerMoney;
    }
}