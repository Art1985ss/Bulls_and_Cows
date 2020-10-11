package bullscows;

public class Application {
    private final ValidatedUserInput userInput = new ValidatedUserInput();


    public void execute() {
        Code code = null;
        int codeLength = 0;
        System.out.println("Input the length of the secret code:");
        codeLength = userInput.getInteger();
        System.out.println("Input the number of possible symbols in the code:");
        int possibleCharacters = userInput.getInteger();
        code = new Code(codeLength, possibleCharacters);
        Grade grade = new Grade(codeLength);
        System.out.println("Okay, let's start a game!");
        int count = 1;
        while (!grade.isSolved()) {
            System.out.println("Turn " + count + ":");
            grade = code.check(new Code(userInput.getCodeString()));
            System.out.println(grade);
            count++;
        }
        System.out.println("Congratulations! You guessed the secret code.");
    }
}
