package vendingmachine.domain;

public class Item {
    private String name;
    private Price price;
    private int quantity;

    public Item(String name, Price price, int quantity) {
        this.name = name;
        this.price = price;
        validateQuantity(quantity);
        this.quantity = quantity;
    }

    private void validateQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("상품의 수량은 1개 이상이여야 합니다.");
        }
    }
}
