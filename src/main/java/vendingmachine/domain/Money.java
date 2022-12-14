package vendingmachine.domain;

public class Money {
    private int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("금액은 0원 이상이여야 합니다.");
        }

        if (money % 10 != 0) {
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
