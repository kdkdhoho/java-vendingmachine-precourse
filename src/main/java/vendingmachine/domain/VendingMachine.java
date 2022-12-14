package vendingmachine.domain;

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
}
