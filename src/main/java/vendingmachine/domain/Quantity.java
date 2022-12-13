package vendingmachine.domain;

public class Quantity {
    private static final int MIN_VALUE = 0;

    private final int quantity;

    public Quantity(int quantity) {
        validate(quantity);
        this.quantity = quantity;
    }

    private void validate(int quantity) {
        if (quantity < MIN_VALUE) {
            throw new IllegalArgumentException("수량은 1개 이상이여야 합니다.");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isLowerThan(int value) {
        return quantity < value;
    }

    public Quantity minus() {
        return new Quantity(quantity - 1);
    }
}
