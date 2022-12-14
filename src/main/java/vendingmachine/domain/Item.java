package vendingmachine.domain;

import java.util.Objects;

public class Item implements Comparable<Item> {
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

    public int compare(int money) {
        int priceValue = price.getValue();
        if (priceValue < money) {
            return -1;
        }
        if (priceValue > money) {
            return 1;
        }
        return 0;
    }

    public boolean isSameName(String itemName) {
        return name.equals(itemName);
    }

    public boolean isSoldOut() {
        return quantity <= 0;
    }

    public void buy() {
        if (quantity < 1) {
            throw new IllegalArgumentException("수량이 존재하지 않습니다.");
        }
        this.quantity--;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int compareTo(Item other) {
        return price.getValue() - other.getPrice().getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getQuantity() == item.getQuantity() && Objects.equals(getName(), item.getName()) && Objects.equals(getPrice(), item.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getQuantity());
    }
}
