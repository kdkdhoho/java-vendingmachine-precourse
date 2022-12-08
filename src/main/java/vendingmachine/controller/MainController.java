package vendingmachine.controller;

import vendingmachine.domain.Coin;
import vendingmachine.service.MainService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.Map;
import java.util.function.Supplier;

public class MainController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MainService mainService = new MainService();

    public void run() {
        setupVendingMachine();
        setUpItems();
    }

    private void setupVendingMachine() {
        String vendingMachineMoney = repeat(inputView::readVendingMachineMoney);
        mainService.setUpVendingMachine(vendingMachineMoney);
        Map<Coin, Integer> vendingMachineCoins = mainService.getVendingMachineCoins();
        outputView.printVendingMachineCoins(vendingMachineCoins);
    }

    private void setUpItems() {
        String items = repeat(inputView::readItems);
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
