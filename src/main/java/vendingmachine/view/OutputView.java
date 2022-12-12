package vendingmachine.view;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
