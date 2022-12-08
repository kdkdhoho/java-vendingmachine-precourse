package vendingmachine.domain;

public class InsertMoney {
    private int insertMoney;

    public InsertMoney(int insertMoney) {
        this.insertMoney = insertMoney;
    }

    public int get() {
        return insertMoney;
    }

    public void calculate(Item item) {
        this.insertMoney = item.calculate(this.insertMoney);
    }
}
