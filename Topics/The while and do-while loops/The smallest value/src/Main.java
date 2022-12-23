import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here

        long input = scanner.nextLong();
        long total = 1;
        for (int i = 1; i < input; i++) {
            long currentFactorialValue = factorialUsingRecursion(i); 
            if (currentFactorialValue > input) {
                total = i;
                break;
            }
        }
        System.out.println(total);
    }
    

    public static long factorialUsingRecursion(long n) { 
        if (n <= 2) {
            return n;
        }
        return n * factorialUsingRecursion(n - 1);
    }
}
