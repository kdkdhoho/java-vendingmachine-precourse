package vendingmachine.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private final Map<Coin, Integer> coins;
    private Items items;
    private InsertMoney insertMoney;

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
        this.insertMoney = new InsertMoney(money);
    }
}
