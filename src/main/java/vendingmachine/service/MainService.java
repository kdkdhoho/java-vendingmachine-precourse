package vendingmachine.service;

import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;

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
}
