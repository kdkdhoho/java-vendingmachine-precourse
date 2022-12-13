package vendingmachine.controller;

import vendingmachine.service.MainService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MainController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MainService mainService = new MainService();

    public void run() {
        run(this::initMachineMoney);
        outputView.printMachineCoins(mainService.getMachineCoins());
        run(this::initItems);
        run(this::initConsumerMoney);
    }

    private void initMachineMoney() {
        int machineMoney = repeat(inputView::readMachineMoney);
        mainService.initMachineMoney(machineMoney);
    }

    private void initItems() {
        List<String[]> items = repeat(inputView::readItems);
        mainService.initItems(items);
    }

    private void initConsumerMoney() {
        int consumerMoney = repeat(inputView::readConsumerMoney);
        mainService.initConsumerMoney(consumerMoney);
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
}
