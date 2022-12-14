package vendingmachine.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String INVALID_INPUT_MESSAGE = "입력이 잘못되었습니다.";

    public int readMachineMoney() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
        String input = readLine();
        System.out.println();
        return toInt(input);
    }

    public List<String[]> readItems() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요. 예: [콜라,1500,20];[사이다,1000,10]");
        String input = readLine();
        System.out.println();

        List<String> items = firstProcess(input);
        List<String[]> details = secondProcess(items);
        validate(details);
        return details;
    }

    private List<String> firstProcess(String input) {
        String[] items = input.split(";");
        return Arrays.stream(items)
                .map(item -> item.substring(1, item.length() - 1))
                .collect(Collectors.toList());
    }

    private List<String[]> secondProcess(List<String> items) {
        return items.stream()
                .map(item -> item.split(","))
                .collect(Collectors.toList());
    }

    private void validate(List<String[]> details) {
        for (String[] detail : details) {
            try {
                validateEmpty(detail[0]);
                toInt(detail[1]);
                toInt(detail[2]);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
            }
        }
    }

    private void validateEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("공백이 포함되어 있습니다.");
        }
    }

    public int readInsertMoney() {
        System.out.println("투입 금액을 입력해 주세요.");
        String input = readLine();
        System.out.println();
        return toInt(input);
    }

    private int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INVALID_INPUT_MESSAGE);
        }
    }
}
