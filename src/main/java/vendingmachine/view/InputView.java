package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final int IDX_PRICE = 1;
    private static final int IDX_QUANTITY = 2;

    public int readMachineMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String input = readLine();
        return toInt(input);
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("다시 입력해주세요.");
        }
    }

    public List<String[]> readItems() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요. 예) [콜라,1500,20];[사이다,1000,10]");
        String[] input = readLine().split(";");
        List<String> items = beforeProcess(input);
        validateItems(items);
        return afterProcess(items);
    }

    private List<String> beforeProcess(String[] input) {
        return Arrays.stream(input)
                .map(data -> data.substring(1, data.length() - 1))
                .collect(Collectors.toList());
    }

    private void validateItems(List<String> items) {
        for (String item : items) {
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
        try {
            toInt(details[IDX_PRICE]);
            toInt(details[IDX_QUANTITY]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("다시 입력해주세요");
        }
    }

    private List<String[]> afterProcess(List<String> input) {
        List<String[]> result = new ArrayList<>();
        for (String item : input) {
            String[] details = item.split(",");
            result.add(details);
        }
        return result;
    }

    public int readUserMoney() {
        System.out.println(System.lineSeparator() + "투입 금액을 입력해 주세요.");
        String input = readLine();
        return toInt(input);
    }

}
