package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public int readMachineMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String input = readLine();
        System.out.println();
        return toInt(input);
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요");
        }
    }
}
