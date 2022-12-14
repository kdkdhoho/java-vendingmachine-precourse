package vendingmachine.domain;

public class Money {
    private final static int MIN_VALUE = 0;
    private final static int UNIT = 10;

    private int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money < MIN_VALUE) {
            throw new IllegalArgumentException("금액은 0원 이상이여야 합니다.");
        }

        if (money % UNIT != 0) {
            throw new IllegalArgumentException("금액은 10원으로 나눠떨어져야 합니다.");
        }
    }

    public int getMoney() {
        return money;
    }

    public void subtract(int value) {
        int result = money - value;

        if (result < 0) {
            money = 0;
            return;
        }
        money = result;
    }
}