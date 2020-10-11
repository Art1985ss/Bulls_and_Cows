package bullscows;

public class Grade {
    private final int length;
    private int bulls;
    private int cows;

    public Grade(int length, int bulls, int cows) {
        this.length = length;
        this.bulls = bulls;
        this.cows = cows;
    }

    public Grade(int length) {
        this.length = length;
        this.bulls = 0;
        this.cows = 0;
    }

    public void addBull() {
        bulls++;
    }

    public void addCow() {
        cows++;
    }

    public boolean isSolved() {
        return bulls == length;
    }

    @Override
    public String toString() {
        String text = "Grade: ";
        if (bulls > 0 && cows > 0) {
            return text + bulls + " bull(s)" + " and "
                    + cows + " cow(s)";
        }
        if (bulls > 0) {
            return text + bulls + " bull(s)" + ".";
        }
        if (cows > 0) {
            return text + cows + " cow(s)";
        }
        return text + "None.";
    }
}
