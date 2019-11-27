
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Q9 {

    public static void main(String args[]) {
        Scanner scann = new Scanner(System.in);
        int n = 0;
        while (true) {
            try {

                System.out.println("Enter the number of n");
                n = scann.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input: " + scann.nextLine());
                continue;
            }

        }
        int[] num = new int[n];
        System.out.println("The Fibonacci numbers are : ");
        for(int i=1;i<=n;i++){
            if(i==n){
                System.out.print(fibonacci(i)+" ");
            }else{
                System.out.print(fibonacci(i)+", ");
            }
            
        }
        System.out.println("");
    }

    //This method is use the recursive method
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
