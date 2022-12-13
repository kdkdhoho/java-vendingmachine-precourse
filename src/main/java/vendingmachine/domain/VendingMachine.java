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

    public boolean canBuy() {
        Price minPrice = getMinPrice();
        if (consumerMoney.isLowerThan(minPrice) || isSoldOut()) {
            return false;
        }
        return true;
    }

    private Price getMinPrice() {
        Item minPriceItem = items.getMinPriceItem();
        return minPriceItem.getPrice();
    }

    private boolean isSoldOut() {
        return items.isSoldOut();
    }

    public Item find(String itemName) {
        return items.find(itemName);
    }

    public void buy(Item item) {
        items.buy(item);
        consumerMoney = consumerMoney.calculate(item);
    }

    public Money getConsumerMoney() {
        return this.consumerMoney;
    }
}