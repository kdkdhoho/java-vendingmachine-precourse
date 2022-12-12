package vendingmachine.controller;

import vendingmachine.service.MainService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class MainController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final MainService mainService = new MainService();

    public void run() {
        repeat(this::initMachineMoney);
        outputView.printMachineCoins(mainService.getMachineCoins());

        List<String> items = repeat(inputView::readItems);
    }

    private boolean initMachineMoney() {
        int machineMoney = repeat(inputView::readMachineMoney);
        return mainService.initMachineMoney(machineMoney);
    }

    private <T> T repeat(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeat(reader);
        }
    }
}
