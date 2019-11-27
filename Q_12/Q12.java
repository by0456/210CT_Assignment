
import java.util.InputMismatchException;
import java.util.Scanner;

public class Q12 {

    public static void main(String[] args) {
        Q12 wk = new Q12();
        int length;
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {

                System.out.println("Enter the number of the items");
                length = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input: " + scan.nextLine());
                continue;
            }
        }
        int sequence[] = new int[length];
        for (int i = 0; i < length; i++) {
            while (true) {
                try {

                    System.out.println("Enter the value");
                    sequence[i] = scan.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input: " + scan.nextLine());
                    continue;
                }

            }
        }
        int n = sequence.length - 1;

        System.out.println("The sequence is : ");
        wk.show(sequence);
        wk.quickSort(sequence, 0, n);
        System.out.println("Quick sort : ");
        wk.show(sequence);

    }

    public void show(int sequence[]) {
        System.out.print(" [ ");
        for (int i = 0; i < sequence.length; i++) {
            if (i != sequence.length - 1) {
                System.out.print(sequence[i] + ", ");
            } else {
                System.out.print(sequence[i]);
            }
        }
        System.out.println(" ] ");
    }

    public int partition(int sequence[], int start, int end) {
        int pivot = sequence[end];
        int i = (start - 1);

        for (int j = start; j < end; j++) {
            if (sequence[j] < pivot) {
                i++;

                int swapTemp = sequence[i];
                sequence[i] = sequence[j];
                sequence[j] = swapTemp;
            }
        }

        int swapTemp = sequence[i + 1];
        sequence[i + 1] = sequence[end];
        sequence[end] = swapTemp;

        return i + 1;
    }

    //This method is the recursive method to the sort the sequence
    public void quickSort(int sequence[], int start, int end) {
        if (start < end) {
            int partitionIndex = partition(sequence, start, end);

            quickSort(sequence, start, partitionIndex - 1);
            quickSort(sequence, partitionIndex + 1, end);
        }
    }
}
