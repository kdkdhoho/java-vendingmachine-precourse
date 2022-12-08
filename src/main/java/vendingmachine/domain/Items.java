package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

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
}
