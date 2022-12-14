package vendingmachine.service;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Item;
import vendingmachine.domain.Items;
import vendingmachine.domain.Money;
import vendingmachine.domain.Price;
import vendingmachine.domain.VendingMachine;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainService {
    private VendingMachine vendingMachine;

    public Map<Coin, Integer> changeCoins(int money) {
        return Coin.change(money);
    }

    public void initVendingMachine(Map<Coin, Integer> machineCoins, List<String[]> inputItems) {
        Coins coins = new Coins(machineCoins);
        Items items = new Items(toItems(inputItems));
        vendingMachine = new VendingMachine(coins, items);
    }

    private List<Item> toItems(List<String[]> inputItems) {
        return inputItems.stream()
                .map(item -> {
                    String name = item[0];
                    Price price = new Price(item[1]);
                    int quantity = Integer.parseInt(item[2]);

                    return new Item(name, price, quantity);
                })
                .collect(Collectors.toList());
    }

    public void insertMoney(int money) {
        vendingMachine.insertMoney(new Money(money));
    }
}
