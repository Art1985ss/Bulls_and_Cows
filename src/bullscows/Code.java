package bullscows;

import java.util.Random;

public class Code {
    private final int codeLength;
    private final String string;

    public Code(String string) {
        this.string = string;
        codeLength = this.string.length();
    }

    public Code(int codeLength, int possibleCharacters) throws CodeException {
        if (codeLength == 0) {
            throw new CodeException("Length of the code should be at least 1");
        }
        if (codeLength > 36) {
            throw new CodeException("maximum possible code length is 36");
        }
        if (codeLength > possibleCharacters) {
            throw new CodeException("it's not possible to generate a code with a length of " +
                    "" + codeLength + " with " + possibleCharacters + " unique symbols.");
        }
        if (possibleCharacters > 36) {
            throw new CodeException("maximum number of possible symbols in the code is 36 (0-9, a-z).");
        }
        this.codeLength = codeLength;
        string = generateRandom(possibleCharacters);
    }

    public Grade check(Code code) {
        if (this.string.equals(code.string)) {
            return new Grade(codeLength, codeLength, 0);
        }
        if (allCharactersSame(code.string)) {
            if (string.contains(code.string.substring(0, 1))) {
                return new Grade(codeLength, 1, 0);
            }
        }
        Grade grade = new Grade(codeLength);
        String temp = this.string;
        for (int i = 0; i < codeLength; i++) {
            char ch1 = string.charAt(i);
            char ch2 = code.string.charAt(i);
            if (ch1 == ch2) {
                grade.addBull();
                continue;
            }
            String s = String.valueOf(ch2);
            if (temp.contains(s)) {
                temp = temp.replace(s, "");
                grade.addCow();
            }
        }
        return grade;
    }

    private boolean allCharactersSame(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++)
            if (s.charAt(i) != s.charAt(0))
                return false;
        return true;
    }

    private String generateRandom(int possibleCharacters) {
        char a = 'a';
        StringBuilder sb = new StringBuilder();
        while (sb.length() < codeLength) {
            Random random = new Random();
            String num;
            int rnd = random.nextInt(possibleCharacters);
            if (rnd > 9) {
                num = String.valueOf((char) (a + rnd - 10));
            } else {
                num = String.valueOf(rnd);
            }
            if (sb.toString().contains(num)) {
                continue;
            }
            sb.append(num);
        }
        System.out.println(sb.toString());
        System.out.println("The secret is prepared: " + "*".repeat(codeLength) + " (0-9, " + a + "-" + (char) (a + possibleCharacters - 11) + ").");
        return sb.toString();
    }

    @Override
    public String toString() {
        return string;
    }
}
