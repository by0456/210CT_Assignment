
import java.util.Scanner;


public class TestArrayQueue {

    public static void main(String[] args) {
		ArrayQueue q = new ArrayQueue(20);
		Scanner scan = new Scanner(System.in);
                q.enqueue("84");
                System.out.println(q);
                q.enqueue("abc");
                System.out.println(q);
                q.enqueue("cde");
                System.out.println(q);
                q.enqueue("123");
                System.out.println(q);
                System.out.println("removed : "+q.dequeue());
                System.out.println(q);
                System.out.println("removed : "+q.dequeue());
                System.out.println(q);
                System.out.println("removed : "+q.dequeue());
                System.out.println(q);
                System.out.println("removed : "+q.dequeue());
                System.out.println(q);
                
 
    }

} 