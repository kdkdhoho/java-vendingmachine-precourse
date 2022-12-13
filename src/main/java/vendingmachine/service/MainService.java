package vendingmachine.service;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Item;
import vendingmachine.domain.Money;
import vendingmachine.domain.Price;
import vendingmachine.domain.Quantity;
import vendingmachine.domain.VendingMachine;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainService {
    private final VendingMachine vendingMachine = new VendingMachine();

    public void initMachineMoney(int machineMoney) {
        vendingMachine.initCoins(new Coins(new Money(machineMoney)));
    }

    public Map<Coin, Integer> getMachineCoins() {
        return vendingMachine.getCoins();
    }

    public void initItems(List<String[]> items) {
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

    public void initConsumerMoney(int consumerMoney) {
        vendingMachine.initConsumerMoney(new Money(consumerMoney));
    }

    public boolean canBuy() {
        return vendingMachine.canBuy();
    }

    public int getInsertMoney() {
        return vendingMachine.getConsumerMoney().getMoney();
    }

    public void buyItem(String itemName) {
        Item item = vendingMachine.find(itemName);
        vendingMachine.buy(item);
    }
}
