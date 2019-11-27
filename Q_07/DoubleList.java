   public class DoubleList { 
    Node head; // head of list 
  
    public void addToHead(Object item) 
    { 
        Node node = new Node(item); 
        node.next = head; 
        node.prev = null; 
        if (head != null) {
            head.prev = node; 
        }
        head = node; 
    } 
    
    public void addToAfter(Node givenNode, Object item) 
    { 
        if (givenNode == null) { 
            System.out.println("The given node cannot be NULL "); 
            return; 
        } 
        Node node = new Node(item); 
        node.next = givenNode.next; 
        givenNode.next = node; 
        node.prev = givenNode; 
        if (node.next != null) 
            node.next.prev = node; 
    } 
  

    public void addToEnd(Object item) 
    { 
        Node node = new Node(item); 
        Node last = head; 
        node.next = null; 
        if (head == null) { 
            node.prev = null; 
            head = node; 
            return; 
        } 
        while (last.next != null) {
            last = last.next; 
        }
        last.next = node; 
        node.prev = last; 
    } 
    public boolean search(Object item){
        Node node = head;
        Boolean isHere = false;
        while(node != null){
            if(node.data.equals(item)){
                isHere = true;
                break;
            }
            node = node.next; 
        }
        return isHere;
    }

    public String toString() { 
        Node node = head;
        String s = "";
        while (node != null) { 
            if(node.next==null){
                s+=node.data+"";
            }else{
                s+=node.data+", ";
            }
            node = node.next; 
        } 
        return s;
    } 
} 
  