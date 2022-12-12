package vendingmachine.domain;

import java.util.Objects;

public class Money {
    private static final int UNIT = 10;
    public static final int MIN_VALUE = 0;

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        validateRange(money);
        validateUnit(money);
    }

    private void validateRange(int money) {
        if (money < MIN_VALUE) {
            throw new IllegalArgumentException("금액은 " + MIN_VALUE + "원 이상이여야 합니다.");
        }
    }

    private void validateUnit(int money) {
        if (money % UNIT != 0) {
            throw new IllegalArgumentException("금액은 " + UNIT + "원으로 나누어떨어져야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    public int getMoney() {
        return money;
    }

    public boolean isMoreThanZero() {
        return this.money > 0;
    }

    public boolean isBiggerOrEqualThan(int value) {
        return this.money >= value;
    }

    public Money subtract(int value) {
        return new Money(this.money - value);
    }
}
