package vendingmachine.domain;

import java.util.Objects;

public class Item implements Comparable {
    private final String name;
    private Price price;
    private Quantity quantity;

    public Item(String name, Price price, Quantity quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    @Override
    public int compareTo(Object o) {
        Item other = (Item)o;
        return this.price.compareTo(other.price);
    }

    public boolean isSoldOut() {
        return this.quantity.isLowerThan(1);
    }

    public boolean is(String itemName) {
        return name.equals(itemName);
    }

    public void minusQuantity() {
        this.quantity = quantity.minus();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(getName(), item.getName()) && Objects.equals(getPrice(), item.getPrice()) && Objects.equals(getQuantity(), item.getQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getQuantity());
    }

    public int calculateMoney(int money) {
        return price.calculateMoney(money);
    }
}
