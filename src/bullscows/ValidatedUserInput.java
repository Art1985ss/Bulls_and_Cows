package bullscows;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidatedUserInput {
    private static final Pattern CODE_PATTERN = Pattern.compile("[0-9a-z]+");
    private final Scanner scanner = new Scanner(System.in);

    public int getInteger() {
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new CodeException("\"" + input + "\"isn 't a valid number.");
        }
    }

    public String getCodeString() {
        String input = scanner.nextLine();
        if (CODE_PATTERN.matcher(input).matches()) {
            return input;
        }
        throw new CodeException("Incorrect symbols!");
    }
}
