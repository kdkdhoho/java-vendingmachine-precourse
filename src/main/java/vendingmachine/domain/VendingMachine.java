package vendingmachine.domain;

import vendingmachine.domain.money.RemainMoney;
import vendingmachine.domain.money.InsertMoney;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private final Map<Coin, Integer> coins;
    private Items items;
    private InsertMoney insertMoney;
    private RemainMoney remainMoney;

    public VendingMachine(int money) {
        coins = Coin.exchange(money);
    }

    public Map<Coin, Integer> getCoins() {
        return Collections.unmodifiableMap(coins);
    }

    public void setUpItems(List<String[]> itemDetails) {
        items = new Items(Items.makeItems(itemDetails));
    }

    public void setUpInsertMoney(int money) {
        this.remainMoney = new RemainMoney(money);
        this.insertMoney = new InsertMoney(money);
    }

    public boolean canBuy() {
        if (remainMoney.get() >= minimumItemPrice() && !items.isAllSoldOut()) {
            return true;
        }
        return false;
    }

    private int minimumItemPrice() {
        return this.items.minimumPrice();
    }

    public RemainMoney getInsertMoney() {
        return remainMoney;
    }

    public boolean canBuy(String itemName) {
        if (items.canBuy(itemName) && !items.isAllSoldOut()) {
            return true;
        }
        return false;
    }

    public void buy(String itemName) {
        Item item = items.find(itemName);
        item.decrease();
        this.remainMoney.calculate(item);
    }

    public Map<Coin, Integer> exchange() {
        if (insertMoney.isBiggerThan(remainMoney)) {
            return this.coins;
        }
        return this.remainMoney.exchange();
    }
}
