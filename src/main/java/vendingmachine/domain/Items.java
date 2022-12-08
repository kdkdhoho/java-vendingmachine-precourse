package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Items {
    private final List<Item> items;

    public Items(List<Item> items) {
        this.items = items;
    }

    public static List<Item> makeItems(List<String[]> itemDetails) {
        List<Item> result = new ArrayList<>();
        for (String[] itemDetail : itemDetails) {
            result.add(new Item(itemDetail));
        }
        return result;
    }

    public boolean isAllSoldOut() {
        return !items.stream()
                .anyMatch(Item::isNotSoldOut);
    }

    public int minimumPrice() {
        return items.stream()
                .map(Item::getPrice)
                .sorted()
                .findFirst()
                .get();
    }

    public boolean canBuy(String itemName) {
        return items.stream()
                .anyMatch(item -> item.canBuy(itemName));
    }

    public Item find(String itemName) {
        return items.stream()
                .filter(item -> item.sameItem(itemName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
