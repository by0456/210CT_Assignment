
class ListNode {

    Object data;
    ListNode next;

    ListNode(Object o) {
        data = o;
        next = null;
    }

    ListNode(Object o, ListNode nextNode) {
        data = o;
        next = nextNode;
    }

    Object getData() {
        return data;
    }

    ListNode getNext() {
        return next;
    }
}
