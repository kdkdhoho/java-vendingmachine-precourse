package vendingmachine.util;

import java.util.ArrayList;
import java.util.List;

public class StringProcessor {
    public static final String DELIMITER_SEMICOLON = ";";
    public static final String DELIMITER_COMMA = ",";

    public static List<String> firstPreProcess(String input) {
        List<String> result = new ArrayList<>();

        String[] items = input.split(DELIMITER_SEMICOLON);
        for (String item : items) {
            StringBuilder stringBuilder = new StringBuilder(item);
            stringBuilder.delete(item.length() - 1, item.length());
            stringBuilder.delete(0, 1);
            result.add(stringBuilder.toString());
        }
        return result;
    }

    public static List<String[]> secondPreProcess(List<String> items) {
        List<String[]> result = new ArrayList<>();

        for (String item : items) {
            String[] itemDetails = item.split(DELIMITER_COMMA);
            result.add(itemDetails);
        }
        return result;
    }
}
