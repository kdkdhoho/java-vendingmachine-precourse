package vendingmachine.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Items {
    private final List<Item> items;

    public Items(List<Item> items) {
        this.items = items;
    }

    public Item findMinPriceItem() {
        return items.stream()
                .sorted()
                .findFirst()
                .get();
    }

    public boolean isAllSoldOut() {
        List<Item> soldOutItems = items.stream()
                .filter(Item::isSoldOut)
                .collect(Collectors.toList());

        if (soldOutItems.size() == items.size()) {
            return true;
        }
        return false;
    }

    public Item findByName(String itemName) {
        return items.stream()
                .filter(item -> item.isSameName(itemName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("찾는 상품이 없습니다"));
    }

    public void buy(Item targetItem) {
        Item findItem = items.stream()
                .filter(item -> item.equals(targetItem))
                .findFirst()
                .get();
        findItem.buy();
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }
}
