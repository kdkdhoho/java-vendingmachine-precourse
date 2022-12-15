package vendingmachine.controller;

import vendingmachine.domain.Coin;
import vendingmachine.service.MainService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MainController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MainService mainService = new MainService();

    public void run() {
        int machineMoney = repeat(inputView::readMachineMoney);
        Map<Coin, Integer> machineCoins = mainService.changeCoins(machineMoney);
        outputView.printMachineCoins(machineCoins);
        process(this::initVendingMachine, machineCoins);
        run(this::insertMoney);
        while (mainService.canBuy()) {
            run(this::buyItem);
        }
        outputView.printChanges(mainService.change(), mainService.getRemainMoney());
    }

    private void initVendingMachine(Map<Coin, Integer> machineCoins) {
        List<String[]> items = repeat(inputView::readItems);
        mainService.initVendingMachine(machineCoins, items);
    }

    private void insertMoney() {
        int insertMoney = repeat(inputView::readInsertMoney);
        mainService.insertMoney(insertMoney);
    }

    private void buyItem() {
        outputView.printRemainMoney(mainService.getRemainMoney());
        String itemName = repeat(inputView::readItemName);
        mainService.buy(itemName);
    }

    private <T> T repeat(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeat(reader);
        }
    }

    private <T> void run(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            run(runnable);
        }
    }

    private <T> void process(Consumer<T> consumer, T t) {
        try {
            consumer.accept(t);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            process(consumer, t);
        }
    }
}
