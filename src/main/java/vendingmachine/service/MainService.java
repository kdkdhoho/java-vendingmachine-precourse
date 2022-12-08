package vendingmachine.service;

import vendingmachine.domain.VendingMachine;

public class MainService {
    private VendingMachine vendingMachine;

    public void setUpVendingMachine(String input) {
        int money = Integer.parseInt(input);
        vendingMachine = new VendingMachine(money);
    }
}
