package bullscows;

import java.util.Arrays;
import java.util.HashSet;

public class Grader {
    public static String gradeString(int numberOfCows, int numberOfBulls) {
        if (numberOfCows == 0 && numberOfBulls == 0) {
            return "Grade: None.";
        } else if (numberOfCows == 0 && numberOfBulls > 0) {
            return String.format("Grade: %d bull(s).", numberOfBulls);
        } else if (numberOfCows > 0 && numberOfBulls == 0) {
            return String.format("Grade: %d cows(s).", numberOfCows);
        } else {
            return String.format("Grade: %d bull(s) and %d cow(s).", numberOfBulls, numberOfCows);
        }
    }

    public static int calculateNumberOfBulls(String targetNumber, String userInput) {

        int numberOfBulls = 0;

        for (int i = 0; i < targetNumber.length(); i++ ) {
            if (targetNumber.charAt(i) == userInput.charAt(i)) {
                numberOfBulls++;
            }
        }

        return numberOfBulls;
    }

    public static int calculateNumberOfCows(String targetNumber, String userInput) {

        int numberOfCows = 0;

        //String targetNumberAsString = String.valueOf(targetNumber);


        for (int i = 0; i < targetNumber.length(); i++ ) {
            char charInTargetNumber = targetNumber.charAt(i);
            char charInUserInputNumber = userInput.charAt(i);

            if (charInTargetNumber == charInUserInputNumber) {
                continue;
            }
            if (userInput.contains(String.valueOf(charInTargetNumber))) {
                numberOfCows++;
            }
        }

        return numberOfCows;
    }

}
