
import java.util.*;

public class Q1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        int[] v = new int[]{5, 10, 20, 50, 100, 500, 1000, 5000};
        calculate(v);
        
        while (true) {
            System.out.println("Enter the number to calculate the values"
                    + " of n(n-1) / 2 and 2n + 26 : ");
            try {
                n = scanner.nextInt();
            } catch (InputMismatchException e) {
                // if the input is not a number, then will let the user input again
                System.out.println("Invalid input: " + scanner.nextLine());
                continue;
            }

            calculate(n);
            break;
        }

    }

    public static void calculate(int n) {
        //This method is present the information as a table for a number
        System.out.print("\tn =          ");
            System.out.print("\t" + n);      
            System.out.println("");
        System.out.print("\tn(n-1)/2 = ");
        //The result of n(n-1)/2
        System.out.print("\t" + (n * (n - 1) / 2) + " ");
        System.out.println("");
        //The result of 2n + 26
        System.out.print("\t2n+26 = ");
        System.out.print("\t" + (2 * n + 26) + " ");
        System.out.println("\n");

    }

    public static void calculate(int[] n) {
        //This method is present the information as a table for a array number
        System.out.print("\tn =          ");
        for (int i = 0; i < n.length; i++) {
            System.out.print("\t" + n[i] + " ");
        }
        System.out.println("");
        System.out.print("\tn(n-1) / 2 = ");
        //The result of n(n-1)/2
        for (int i = 0; i < n.length; i++) {
            System.out.print("\t" + ((n[i]) * (n[i] - 1) / 2) + " ");
        }
        System.out.println("");
        System.out.print("\t2n + 26 = ");
        //The result of 2n + 26
        for (int i = 0; i < n.length; i++) {
            System.out.print("\t" + (2 * (n[i]) + 26) + " ");
        }
        System.out.println("\n");
    }

}
