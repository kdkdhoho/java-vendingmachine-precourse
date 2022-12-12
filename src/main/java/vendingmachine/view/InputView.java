package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static final int IDX_PRICE = 1;
    public static final int IDX_QUANTITY = 2;

    public int readMachineMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String input = Console.readLine();
        return toInt(input);
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력헤주세요.");
        }
    }

    public List<String> readItems() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요. 예) [콜라,1500,20];[사이다,1000,10]");
        String[] input = Console.readLine().split(";");
        List<String> items = Arrays.asList(input);
        validateItems(items);
        return items;
    }

    private void validateItems(List<String> items) {
        for (String item : items) {
            item = item.substring(1, item.length() - 1);
            String[] details = item.split(",");
            validateBlank(details);
            validateNumeric(details);
        }
    }

    private void validateBlank(String[] details) {
        for (String detail : details) {
            String trim = detail.trim();
            if (trim.isEmpty()) {
                throw new IllegalArgumentException("공백없이 입력해주세요.");
            }
        }
    }

    private void validateNumeric(String[] details) {
        toInt(details[IDX_PRICE]);
        toInt(details[IDX_QUANTITY]);
    }
}
