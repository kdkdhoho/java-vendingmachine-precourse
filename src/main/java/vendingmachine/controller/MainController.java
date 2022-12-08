package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Coin;
import vendingmachine.service.MainService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class MainController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MainService mainService = new MainService();

    public void run() {
        setupVendingMachine();
        setUpItems();
        readInsertMoney();

        while (mainService.canBuy()) {
            outputView.printInsertMoney(mainService.getInsertMoney());
            repeat(this::buyItem);
        }
        outputView.printInsertMoney(mainService.getInsertMoney());
    }

    private void setupVendingMachine() {
        String vendingMachineMoney = repeat(inputView::readVendingMachineMoney);
        mainService.setUpVendingMachine(vendingMachineMoney);
        Map<Coin, Integer> vendingMachineCoins = mainService.getVendingMachineCoins();
        outputView.printVendingMachineCoins(vendingMachineCoins);
    }

    private void setUpItems() {
        String items = repeat(inputView::readItems);
        mainService.setUpItems(items);
    }

    private void readInsertMoney() {
        String insertMoney = repeat(inputView::readInsertMoney);
        mainService.setUpInsertMoney(insertMoney);
    }

    private Boolean buyItem() {
        String itemName = inputView.readItemName();
        return mainService.buy(itemName);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeat(inputReader);
        }
    }
}
