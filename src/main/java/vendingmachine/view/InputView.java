package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readMachineMoney() {
        String input = Console.readLine();
        return toInt(input);
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }
}
