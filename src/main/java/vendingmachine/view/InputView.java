package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private final InputValidator inputValidator = new InputValidator();

    public String readVendingMachineMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String input = readLine();
        inputValidator.validateVendingMachineMoney(input);
        return input;
    }
}
