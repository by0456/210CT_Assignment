
import java.util.*;

public class Q2 {

    public static void main(String[] args) {
        //The resutle of calculator
        double result = 0;
        //The numbers for calculate
        double num1, num2;
        //The boolean for the continue calculate after the calculator
        boolean con = false;
        String operations = "";
        int type;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (!con) {

                System.out.println("Please choose the action, 0 : Exit, 1 : Calculator");

                try {
                    type = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input: " + scanner.nextLine());
                    continue;
                }

                if (type == 0) {
                    //If user do not want to calculate, then will exit the program
                    break;
                } else if (type == 1) {
                    //This while loop check the num 1, num 1 should be number
                    while (true) {
                        System.out.println("Enter the number 1 : ");

                        try {
                            num1 = scanner.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input: " + scanner.nextLine());
                            continue;
                        }
                        break;

                    }

                    //This while loop check the operation, the operation should be "+" or "-" or "*" or "/"
                    while (true) {
                        System.out.println("Enter the basic + - * / operations");
                        operations = scanner.next();
                        if (operations.equals("+") || operations.equals("-")
                                || operations.equals("*") || operations.equals("/")) {
                            break;

                        } else {
                            System.out.println("* please enter the basic + - * / operations operations!!");
                            continue;

                        }
                    }
                    //This while loop check the num 2, num 2 should be number
                    while (true) {
                        System.out.println("Enter the number 2 : ");
                        try {
                            num2 = scanner.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input: " + scanner.nextLine());
                            continue;
                        }
                        break;
                    }

                    System.out.println(num1 + " " + operations + " " + num2);
                    System.out.print("= ");
                    result = calculator(num1, operations, num2);
                    con = true;
                    continue;

                } else {
                    //If the type is not "0" or "1", then show the message remind user
                    System.out.println("* Please enter the correct number !!");
                    continue;
                }

            } else {
                //After the calculate, it can according the result continue to calculate or enter 'c' to do new calculation                
                System.out.println("You can enter 'c' to do new calculation, or according the result continue to calculate");

                System.out.println("Enter the basic + - * / operations");
                operations = scanner.next();
                if (operations.equals("c") || operations.equals("C")) {
                    con = false;
                    continue;

                } else if (operations.equals("+") || operations.equals("-")
                        || operations.equals("*") || operations.equals("/")) {
                    System.out.println("Enter the number 2 : ");
                    String num3 = scanner.next();
                    if (num3.equals("c") || num3.equals("C")) {
                        con = false;
                        continue;
                    } else {
                        try {
                            Double.valueOf(num3);
                        } catch (NumberFormatException e) {
                            System.out.println("* Please enter the number or press 'c' to run new calculation!!");
                            continue;
                        }
                        System.out.println(result + " " + operations + " " + Double.valueOf(num3));
                        System.out.print("= ");
                        result = calculator(result, operations, Double.valueOf(num3));
                        con = true;

                    }

                } else {
                    System.out.println("* please enter the basic + - * / operations!!");
                    continue;
                }

            }

        }

    }

    public static double calculator(double num1, String operations, double num2) {
        //The calcultor for calculate
        if (operations.equals("+")) {
            System.out.println(num1 + num2);
            return num1 + num2;

        } else if (operations.equals("-")) {
            System.out.println(num1 - num2);
            return num1 - num2;

        } else if (operations.equals("*")) {
            System.out.println(num1 * num2);
            return num1 * num2;

        } else {
            System.out.println((double) num1 / num2);
            return (double) num1 / num2;

        }
    }

}
