package vendingmachine.view;

public class InputValidator {
    public static final int VENDING_MACHINE_MONEY_MINIMUM = 10;
    public static final int VENDING_MACHINE_MONEY_UNIT = 10;
    public static final String PREFIX = "[ERROR] ";
    public static final String ERROR_MONEY_RANGE = PREFIX + "자판기가 보유하고 있는 금액은 10원 이상이어야 합니다.";
    public static final String ERROR_MONEY_UNIT = PREFIX + "자판기가 보유하고 있는 금액은 10원 단위이어야 합니다.";

    public void validateVendingMachineMoney(String input) {
        int money = toInteger(input);
        validateRange(money);
        validateUnit(money);
    }

    private int toInteger(String input) {
        return Integer.parseInt(input);
    }

    private void validateRange(int money) {
        if (money < VENDING_MACHINE_MONEY_MINIMUM) {
            throw new IllegalArgumentException(ERROR_MONEY_RANGE);
        }
    }

    private void validateUnit(int money) {
        if (money % VENDING_MACHINE_MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_MONEY_UNIT);
        }
    }
}
