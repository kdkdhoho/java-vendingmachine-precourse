package vendingmachine.view;

public class OutputView {
    private static final String PREFIX = "[ERROR] ";

    public void printError(String message) {
        System.out.println(PREFIX + message);
    }
}
