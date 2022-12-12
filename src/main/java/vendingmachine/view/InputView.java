package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readMachineMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String input = Console.readLine();
        return toInt(input);
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }
}
