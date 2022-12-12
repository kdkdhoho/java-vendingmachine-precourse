package vendingmachine.service;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;

import java.util.Map;

public class MainService {
    private VendingMachine vendingMachine;

    public boolean initMachineMoney(int machineMoney) {
        vendingMachine = new VendingMachine(new Coins(new Money(machineMoney)));
        return true;
    }

    public Map<Coin, Integer> getMachineCoins() {
        return vendingMachine.getCoins();
    }
}
