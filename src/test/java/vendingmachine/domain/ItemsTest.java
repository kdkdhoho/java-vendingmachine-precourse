package vendingmachine.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemsTest {
    private Items items;

    @DisplayName("최저 가격 Item 찾기 테스트")
    @Test
    void findMinPriceItem() {
        List<Item> details = new ArrayList<>();
        details.add(new Item("콜라", new Price(100), 3));
        details.add(new Item("사이다", new Price(200), 3));
        details.add(new Item("환타", new Price(300), 4));
        items = new Items(details);

        Item minPriceItem = items.findMinPriceItem();
        assertThat(minPriceItem).isEqualTo(new Item("콜라", new Price(100), 3));
    }
}