package vendingmachine.controller;

import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.function.Supplier;

public class MainController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        int machineMoney = repeat(inputView::readMachineMoney);
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
