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

    public String readItems() {
        System.out.println("\n상품명과 가격, 수량을 입력해 주세요. (예: [콜라,1500,20];[사이다,1000,10])");
        String input = readLine();
        inputValidator.validateItems(input);
        return input;
    }

    public String readInsertMoney() {
        System.out.println("\n투입 금액을 입력해 주세요.");
        String input = readLine();
        inputValidator.validateInsertMoney(input);
        return input;
    }

    public String readItemName() {
        System.out.println("\n구매할 상품명을 입력해 주세요.");
        return readLine();
    }
}
