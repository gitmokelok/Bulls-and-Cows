package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Random random = new Random();

//        printGameStartNote();
//        printSingleTurnCard(1, 1234, "1 cow");
//        printSingleTurnCard(2, 2345, "1 bull");
//        printGameEndNote(2345);
        System.out.println("Please, enter the secret code's length:");
        Scanner scanner = new Scanner(System.in);
        String firstInput = scanner.nextLine();
        if (!firstInput.matches("[0-9]+")) {
            System.out.println(String.format("Error: \"%s\" isn't a valid number.", firstInput));
            return;
        }
        int userInputNumber = Integer.parseInt(firstInput);
        if (userInputNumber <= 0) {
            System.out.println("Error: the length should be at least 1.");
            return;
        }
        System.out.println("Input the number of possible symbols in the code:");
        int numberOfPossibleSymbols = Integer.parseInt(scanner.nextLine());
        if (numberOfPossibleSymbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return;
        }
        if (numberOfPossibleSymbols < userInputNumber) {
            System.out.println(String.format("Error: it's not possible to generate a code with a length of %d with %d unique symbols.", userInputNumber, numberOfPossibleSymbols));
            return;
        }

        String secretNumberAsText = generateSecretNumber(userInputNumber, numberOfPossibleSymbols);

        System.out.println(String.format("The secret is prepared: %s (%s).", getMaskedSecretCode(userInputNumber), getStringToOutputInGameBeginning(numberOfPossibleSymbols)));
        System.out.println("Okay, let's start a game!");
        System.out.println(secretNumberAsText);
        int turnCounter = 1;
        while(true) {
            System.out.println(String.format("Turn %d:", turnCounter));
            turnCounter++;
            String userInput = scanner.nextLine().trim();

            int numberOfBulls = Grader.calculateNumberOfBulls(secretNumberAsText, userInput);
            int numberOfCows = Grader.calculateNumberOfCows(secretNumberAsText, userInput);
            System.out.println(String.format("%s", Grader.gradeString(numberOfCows, numberOfBulls)));
            if (numberOfBulls == userInputNumber) {
                break;
            }

        }

        System.out.println("Congratulations! You guessed the secret code.");



//        if (userInputNumber > 10) {
//            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
//        } else {
//            System.out.println(String.format("The random secret number is %s", String.valueOf(secretNumber).substring(0, userInputNumber)));
//        }


//        int numberOfBulls = Grader.calculateNumberOfBulls(secretNumber, userInputNumber);
//        int numberOfCows = Grader.calculateNumberOfCows(secretNumber, userInputNumber);

        //System.out.println(String.format("%s The secret code is %d.", Grader.gradeString(numberOfCows, numberOfBulls), secretNumber));
    }



    public static void printGameStartNote() {
        System.out.println("The secret code is prepared: ****.");
    }

    public static void printSingleTurnCard(int turnNumber, int answerNumber, String grade) {
        System.out.println(String.format("""
                
                Turn %d. Answer
                %d
                Grade: %s.""", turnNumber, answerNumber, grade));

    }

    public static void printGameEndNote(int answerNumber) {
        System.out.println(String.format("Congrats! The Secret code is %d.", answerNumber));
    }

    public static String generateSecretNumber(int length, int numberOfCharsToPickFrom) {
        Random random = new Random(1);

        //a-z - ASCII char codes 97-122
        //0-9 - ASCII char codes 48-57
        String result = "";
        String[] possibleValues = generateArrayOfPossibleValues(numberOfCharsToPickFrom);

        for (int i = 0; i < 36; i++) {

            int randomIndex = random.nextInt(0, numberOfCharsToPickFrom);
            String targetSymbol = possibleValues[randomIndex];
            if (!result.contains(String.valueOf(targetSymbol))) {
                result += targetSymbol;
            }

            if (result.length() == length) {
                break;
            }
        }

        return result;
    }

    //generate array of chars starting [0 1 2 3 4 5 6 7 8 9 a b c ....], the length will depend on the length parameter.
    public static String[] generateArrayOfPossibleValues(int length) {
        String[] charArrayForSecretCode = new String[length];
        for (int i = 0; i < length; i++) {
            if (i < 10) {
                charArrayForSecretCode[i] = String.valueOf(i);
            } else {
                charArrayForSecretCode[i] = String.valueOf((char)(i+87));
            }
        }

        return charArrayForSecretCode;
    }

    public static String getStringToOutputInGameBeginning(int numberOfCharsToPick) {
        String[] charArrayForSecretCode = generateArrayOfPossibleValues(numberOfCharsToPick);

        if (numberOfCharsToPick <= 10) {
            return String.format("%s-%s", 0, charArrayForSecretCode[numberOfCharsToPick-1]);
        } else if (numberOfCharsToPick == 11) {

            return String.format("%s-%s, %s", 0, 9, charArrayForSecretCode[10]);
        }else {
            return String.format("%s-%s, %s-%s", 0, 9, charArrayForSecretCode[11], charArrayForSecretCode[numberOfCharsToPick-1]);
        }
    }

    public static String getMaskedSecretCode(int length) {
        String result = "";

        for (int i = 0; i < length; i++) {
            result += "*";
        }
        return result;
    }

}
