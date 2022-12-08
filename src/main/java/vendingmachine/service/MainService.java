package vendingmachine.service;

import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;
import vendingmachine.util.StringProcessor;

import java.util.List;
import java.util.Map;

public class MainService {
    private VendingMachine vendingMachine;

    public void setUpVendingMachine(String input) {
        int money = Integer.parseInt(input);
        vendingMachine = new VendingMachine(money);
    }

    public Map<Coin, Integer> getVendingMachineCoins() {
        return vendingMachine.getCoins();
    }

    public void setUpItems(String input) {
        List<String> items = StringProcessor.firstPreProcess(input);
        List<String[]> itemDetails = StringProcessor.secondPreProcess(items);
        vendingMachine.setUpItems(itemDetails);
    }
}
