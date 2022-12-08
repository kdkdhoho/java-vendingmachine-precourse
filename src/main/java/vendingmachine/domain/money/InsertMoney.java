package vendingmachine.domain.money;

public class InsertMoney {
    private final int remainMoney;

    public InsertMoney(int remainMoney) {
        this.remainMoney = remainMoney;
    }

    public int get() {
        return remainMoney;
    }

    public boolean isBiggerThan(RemainMoney remainMoney) {
        return remainMoney.isSmallerThan(this.remainMoney);
    }
}
