package vendingmachine.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Items {
    private final List<Item> items;

    public Items(List<Item> items) {
        this.items = items;
    }

    public Item getMinPriceItem() {
        return items.stream()
                .sorted(Item::compareTo)
                .findFirst()
                .get();
    }

    public boolean isSoldOut() {
        List<Item> soldOutItems = items.stream()
                .filter(Item::isSoldOut)
                .collect(Collectors.toList());

        return soldOutItems.size() == items.size();
    }

    public Item find(String itemName) {
        return items.stream()
                .filter(item -> item.is(itemName) && !item.isSoldOut())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("입력한 상품명이 존재하지 않거나, 더 이상 상품이 존재하지 않습니다."));
    }

    public void buy(Item target) {
        Item findItem = find(target);
        findItem.minusQuantity();
    }

    private Item find(Item target) {
        return items.stream()
                .filter(item -> item.equals(target) && item.hashCode() == target.hashCode())
                .findFirst()
                .get();
    }
}
