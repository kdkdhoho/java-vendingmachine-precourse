package vendingmachine.domain;

import java.util.Map;

public class VendingMachine {
    private final Coins coins;
    private final Items items;
    private Money insertMoney;

    public VendingMachine(Coins coins, Items items) {
        this.coins = coins;
        this.items = items;
    }

    public void insertMoney(Money money) {
        this.insertMoney = money;
    }

    public Coins getCoins() {
        return coins;
    }

    public Items getItems() {
        return items;
    }

    public Money getInsertMoney() {
        return insertMoney;
    }

    public boolean canSell() {
        Item minPriceItem = items.findMinPriceItem();
        int insertMoneyValue = insertMoney.getValue();
        int compare = minPriceItem.compare(insertMoneyValue);

        if ((compare) > 0 || (compare == 0 && minPriceItem.isSoldOut()) || items.isAllSoldOut()) {
            return false;
        }
        return true;
    }

    public Item findItem(String itemName) {
        return items.findByName(itemName);
    }

    public void buy(Item targetItem) {
        items.buy(targetItem);

        int price = targetItem.getPrice().getValue();
        insertMoney.subtract(price);
    }

    public Map<Coin, Integer> change() {
        int targetMoney = insertMoney.getValue();
        if (coins.isLowerOrEqualThan(targetMoney)) {
            return coins.getCoins();
        }
        return coins.change(targetMoney);
    }
}
