package vendingmachine.service;

import vendingmachine.domain.Coins;
import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;

public class MainService {
    private VendingMachine vendingMachine;

    public boolean initMachineMoney(int machineMoney) {
        vendingMachine = new VendingMachine(new Coins(new Money(machineMoney)));
        return true;
    }
}
