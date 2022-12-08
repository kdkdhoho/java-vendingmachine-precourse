package vendingmachine.domain.money;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;

import java.util.Map;

public class RemainMoney {
    private int remainMoney;

    public RemainMoney(int remainMoney) {
        this.remainMoney = remainMoney;
    }

    public int get() {
        return remainMoney;
    }

    public void calculate(Item item) {
        this.remainMoney = item.calculate(this.remainMoney);
    }

    public Map<Coin, Integer> exchange() {
        return Coin.exchange(this.remainMoney);
    }

    public boolean isSmallerThan(int remainMoney) {
        return this.remainMoney < remainMoney;
    }
}
