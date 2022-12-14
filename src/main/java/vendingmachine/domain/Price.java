package vendingmachine.domain;

public class Price {
    private final static int MIN_VALUE = 100;
    private final static int UNIT = 10;

    private final int price;

    public Price(int price) {
        validate(price);
        this.price = price;
    }

    public Price(String s) {
        int price = Integer.parseInt(s);
        validate(price);
        this.price = price;
    }

    private void validate(int price) {
        if (price < MIN_VALUE) {
            throw new IllegalArgumentException("상품의 가격은 100원 이상이어야 합니다.");
        }

        if (price % UNIT != 0) {
            throw new IllegalArgumentException("상품의 가격은 10원으로 나눠떨어져야 합니다.");
        }
    }

    public int getPrice() {
        return price;
    }
}
