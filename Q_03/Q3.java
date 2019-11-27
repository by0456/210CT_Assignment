
import java.util.*;

public class Q3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n;
        while (true) {
            try {

                System.out.println("Enter the number to compute the nth value of the harmonic series: ");
                n = scanner.nextDouble();
                System.out.println(compute(n));
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input: " + scanner.nextLine());
                continue;
            }

        }
    }

    public static double compute(double n) {
        //The recursive to compute the nth value of the harmonic series
        if (n < 2) {
            return 1;
        } else {
            return 1 / n + (compute(n - 1));
        }
    }

}
