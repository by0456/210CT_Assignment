
import java.util.Scanner;

public class SimBusStop {

    public static void main(String[] args) {
        ArrayQueue t = new ArrayQueue(50);
        //for enter the data
        int code, time, count;
        //stored the number of bus
        int busCount = 0;
        //stored the number of passenger
        int passenger = 0;
        //stored the number of vacant seats
        int vacantSeats = 0;
        //stored the total of still waiting time
        int stillWaitTime = 0;
        //stored the number of passenger who still is waiting
        int stillWait = 0;
        Integer item;
        int people = 0;
        int wait = 0;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Code (0 for people, 1 for bus, -1 to exit): ");
            code = scan.nextInt();
        } while (code < -1 || code > 1);
        int lastTime = 0;
        while (code != -1) {
            do {
                System.out.println("Arrival time (>=" + Integer.toString(lastTime) + "): ");
                time = scan.nextInt();
            } while (lastTime > time);
            lastTime = time;
            do {
                System.out.println("Arrival count (> 0): ");
                count = scan.nextInt();
            } while (count <= 0);
            if (code == 0) {
                people += count;
                while (count-- > 0) {
                    t.enqueue(new Integer(time));
                }
            } else if (code == 1) {
                busCount++;
                vacantSeats = vacantSeats + count;
                while ((count-- > 0) && !t.empty()) {
                    item = (Integer) t.dequeue();
                    passenger++;
                    vacantSeats--;
                    wait += time - item.intValue();
                }
            }
            do {
                System.out.println("Code (0 for people, 1 for bus, -1 to exit): ");
                code = scan.nextInt();
            } while (code < -1 || code > 1);
        }
        if (!t.empty()) {
            stillWait = t.count;
            while (!t.empty()) {
                stillWaitTime = stillWaitTime + (Integer) t.dequeue();
            }
        }

        System.out.println("");
        if (people != 0) {
            System.out.println(people + " people waited for "
                    + wait + " minutes, average waiting time = "
                    + (float) wait / people + " minutes.");
        }
        System.out.println("The number of buses passed the bus stop: " + busCount);
        System.out.println("Average number of people got on a bus: " + (double) passenger / busCount);
        System.out.println("Average number of vacant seats for a bus leaving the bus stop: " + (double) vacantSeats / busCount);
        if (stillWait != 0) {
            System.out.println(stillWait + " people still waiting at the bus stop, average waiting time = "
                    + (double) stillWaitTime / stillWait + " minutes.");
        } else {
            System.out.println("No people still waiting a the bus stop!!");
        }

    }

}
