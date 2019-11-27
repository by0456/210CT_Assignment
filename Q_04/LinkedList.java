
class LinkedList {

    private ListNode head;
    private ListNode tail;

    public LinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addToHead(Object item) {
        ListNode node = new ListNode(item);
        if (isEmpty()) {
            head = node;
            tail = node;
            node.next = head;
        } else {

            ListNode temp = head;
            node.next = temp;
            head = node;
            tail.next = head;
        }
    }

    public void addToTail(Object item) {
        if (isEmpty()) {
            addToHead(item);
        } else {
            ListNode node = new ListNode(item);
            tail.next = node;
            tail = node;
            tail.next = head;
        }

    }

    public Object removeFromHead() throws EmptyListException {
        Object item = null;
        if (isEmpty()) {
            throw new EmptyListException();
        } else {
            item = head.data;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;

            }
        }

        return item;
    }

    public Object removeFromTail() throws EmptyListException {
        Object item = null;
        if (isEmpty()) {
            throw new EmptyListException();
        }
        item = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            ListNode current = head;
            while (current.next != tail) {
                current = current.next;
            }
            tail = current;
            tail.next = head;
        }
        return item;
    }

    public String toString() {
        String s = "[ ";
        ListNode current = head;
        if (head != null) {
            do {
                s += current.data + " ";
                current = current.next;
            } while (current != head);
        }
        return s + "]";
    }
}
