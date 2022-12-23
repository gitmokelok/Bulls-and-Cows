import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        double u1 = scanner.nextDouble();
        double u2 = scanner.nextDouble();

        double v1 = scanner.nextDouble();
        double v2 = scanner.nextDouble();

        double uLength = Math.sqrt(Math.pow(u1, 2) + Math.pow(u2, 2));
        double vLength = Math.sqrt(Math.pow(v1, 2) + Math.pow(v2, 2));

        double productOfTwoVectors = u1 * v1 + u2 * v2;

        double x = Math.acos(productOfTwoVectors / (uLength * vLength));
        double y = Math.toDegrees(x);
        System.out.println(y);
        
    }
}
