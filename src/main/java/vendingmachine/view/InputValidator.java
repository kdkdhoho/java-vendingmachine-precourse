package vendingmachine.view;

import vendingmachine.util.StringProcessor;

import java.util.ArrayList;
import java.util.List;

public class InputValidator {
    public static final int VENDING_MACHINE_MONEY_MINIMUM = 10;
    public static final int VENDING_MACHINE_MONEY_UNIT = 10;
    public static final int ITEM_PRICE_INDEX = 1;
    public static final int ITEM_AMOUNT_INDEX = 2;
    public static final int ITEM_AMOUNT_MINIMUM = 1;
    public static final int ITEM_PRICE_MINIMUM = 100;
    public static final String PREFIX = "[ERROR] ";
    public static final String ERROR_MONEY_RANGE = PREFIX + "자판기가 보유하고 있는 금액은 10원 이상이어야 합니다.";
    public static final String ERROR_MONEY_UNIT = PREFIX + "자판기가 보유하고 있는 금액은 10원 단위이어야 합니다.";
    public static final String ERROR_STRING = PREFIX + "숫자를 입력해주세요.";
    public static final String ERROR_ITEM_AMOUNT = PREFIX + "상품 수량은 1개 이상이여야 합니다.";


    public void validateVendingMachineMoney(String input) {
        int money = toInteger(input);
        validateRange(money);
        validateUnit(money);
    }

    private int toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_STRING);
        }
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

    public void validateItems(String input) {
        List<String> items = StringProcessor.firstPreProcess(input);
        List<String[]> itemDetails = StringProcessor.secondPreProcess(items);

        for (String[] itemDetail : itemDetails) {
            validatePrice(itemDetail[ITEM_PRICE_INDEX]);
            validateAmount(itemDetail[ITEM_AMOUNT_INDEX]);
        }
    }

    private void validatePrice(String input) {
        int price = toInteger(input);
        if (price < ITEM_PRICE_MINIMUM) {
            throw new IllegalArgumentException(ERROR_MONEY_RANGE);
        }
        if (price % VENDING_MACHINE_MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_MONEY_UNIT);
        }
    }

    private void validateAmount(String input) {
        int amount = toInteger(input);
        if (amount < ITEM_AMOUNT_MINIMUM) {
            throw new IllegalArgumentException(ERROR_ITEM_AMOUNT);
        }
    }
}
