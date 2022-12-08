package vendingmachine.controller;

import vendingmachine.view.InputView;

import java.util.function.Supplier;

public class MainController {
    private final InputView inputView = new InputView();

    public void run() {
        String vendingMachineMoney = repeat(inputView::readVendingMachineMoney);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeat(inputReader);
        }
    }
}
