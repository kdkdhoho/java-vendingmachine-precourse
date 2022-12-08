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

    public void setUpInsertMoney(String input) {
        int money = Integer.parseInt(input);
        vendingMachine.setUpInsertMoney(money);
    }

    public boolean canBuy() {
        return vendingMachine.canBuy();
    }

    public int getInsertMoney() {
        return vendingMachine.getInsertMoney().get();
    }

    public boolean buy(String itemName) {
        if (!vendingMachine.canBuy(itemName)) {
            throw new IllegalArgumentException("[ERROR] 입력한 상품이 없거나 수량이 없습니다. 다시 입력해주세요");
        }
        vendingMachine.buy(itemName);
        return true;
    }
}
