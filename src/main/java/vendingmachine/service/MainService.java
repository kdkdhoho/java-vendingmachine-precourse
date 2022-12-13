package vendingmachine.service;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Item;
import vendingmachine.domain.Money;
import vendingmachine.domain.Price;
import vendingmachine.domain.Quantity;
import vendingmachine.domain.VendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainService {
    private VendingMachine vendingMachine;

    public void initMachineMoney(int machineMoney) {
        vendingMachine = new VendingMachine(new Coins(new Money(machineMoney)));
    }

    public Map<Coin, Integer> getMachineCoins() {
        return vendingMachine.getCoins();
    }

    public void setItems(List<String[]> items) {
        List<Item> result = items.stream()
                .map(item -> {
                    String name = item[0];
                    Price price = new Price(Integer.parseInt(item[1]));
                    Quantity quantity = new Quantity(Integer.parseInt(item[2]));
                    return new Item(name, price, quantity);
                })
                .collect(Collectors.toList());

        vendingMachine.initItems(result);
    }
}
