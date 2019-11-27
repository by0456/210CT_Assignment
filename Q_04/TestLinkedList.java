
public class TestLinkedList {
    public static void main (String args[]) {
		LinkedList s = new LinkedList();
		System.out.println(s);
		System.out.println();

		s.addToTail (new Integer(42));

                System.out.println(s);
		System.out.println();
		s.addToTail (new Character('n'));
		System.out.println(s);
		System.out.println();
		s.addToTail (new String("hello"));
		System.out.println(s);
		System.out.println();
		while (!s.isEmpty()) {
			System.out.println("removed:" + s.removeFromHead());
			System.out.println(s);
			System.out.println();
		}

		s.addToHead (new Integer(42));
		System.out.println(s);
		System.out.println();
		s.addToHead (new Character('n'));
		System.out.println(s);
		System.out.println();
		s.addToHead (new String("hello"));
		System.out.println(s);
		System.out.println();
		while (!s.isEmpty()) {
			System.out.println("removed:" + s.removeFromTail());
			System.out.println(s);
			System.out.println();
		}
	}
    
}
