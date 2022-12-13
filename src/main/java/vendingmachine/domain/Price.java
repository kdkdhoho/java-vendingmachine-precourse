package vendingmachine.domain;

public class Price implements Comparable {
    private static final int MIN_PRICE = 100;
    private static final int UNIT = 10;

    private final int price;

    public Price(int price) {
        validate(price);
        this.price = price;
    }

    private void validate(int price) {
        if (price < MIN_PRICE) {
            throw new IllegalArgumentException("상품의 가격은 " + MIN_PRICE + "원 이상이어야 합니다.");
        }
        if (price % UNIT != 0) {
            throw new IllegalArgumentException("상품의 가격은 " + UNIT + "원으로 나눠떨어져야 합니다.");
        }
    }

    public int getPrice() {
        return price;
    }

    public boolean isBiggerThan(int value) {
        return this.price > value;
    }

    @Override
    public int compareTo(Object o) {
        Price other = (Price)o;
        return this.price - other.price;
    }

    public int calculateMoney(int money) {
        return money - price;
    }
}
