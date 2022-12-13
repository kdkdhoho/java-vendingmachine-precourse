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

        int userMoney = repeat(inputView::readUserMoney);
    }

    private void initMachineMoney() {
        int machineMoney = repeat(inputView::readMachineMoney);
        mainService.initMachineMoney(machineMoney);
    }

    private void initItems() {
        List<String[]> items = repeat(inputView::readItems);
        mainService.setItems(items);
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

    private <T> T apply(Function<T, T> function, T t) {
        try {
            return function.apply(t);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return function.apply(t);
        }
    }
}
