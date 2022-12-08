package vendingmachine.domain;

public class Item {
    private final String name;
    private final int price;
    private int amount;

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

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public boolean isNotSoldOut() {
        return amount > 0;
    }

    public boolean canBuy(String itemName) {
        if (this.name.equals(itemName) && isNotSoldOut()) {
            return true;
        }
        return false;
    }

    public boolean sameItem(String itemName) {
        return this.name.equals(itemName);
    }

    public int calculate(int insertMoney) {
        if (insertMoney >= price) {
            return insertMoney - price;
        }
        return insertMoney;
    }

    public void decrease() {
        this.amount--;
    }
}
