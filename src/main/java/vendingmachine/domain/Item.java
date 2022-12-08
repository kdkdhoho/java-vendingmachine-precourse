package vendingmachine.domain;

public class Item {
    private final String name;
    private final int price;
    private final int amount;

    public Item(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public Item(String[] itemDetails) {
        this.name = itemDetails[0];
        this.price = Integer.parseInt(itemDetails[1]);
        this.amount = Integer.parseInt(itemDetails[2]);
    }
}
