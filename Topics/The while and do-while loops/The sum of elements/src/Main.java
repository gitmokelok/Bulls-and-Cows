import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int sum = 0;
        int userInput = -1;

        while (userInput != 0) {
            userInput = scanner.nextInt();
            sum += userInput;
        }
        System.out.println(sum);

    }
}