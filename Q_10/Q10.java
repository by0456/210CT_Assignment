
public class Q10 {

    public static int[] heap = {98, 38, 93, 33, 21, 6, 63, 81, 32};
    public static int[] sortedList = new int[heap.length];
    //The variable is stored the total number of comparisons from both extraction and construction phases
    public static int count = 0;

    public static void main(String[] args) {
        System.out.println("The sequence :");
        for (int i = 0; i < heap.length; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println("");
        System.out.println("construct phase : ");
        construct();
        for (int i = 0; i < heap.length; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println(" ");
        System.out.println("extract phase : ");
        extract();
        for (int i = 0; i < sortedList.length; i++) {
            System.out.print(sortedList[i] + " ");
        }
        System.out.println(" ");
        System.out.println("The total number of comparisons from both extraction and construction phases : ");
        System.out.println(count);

    }

    public static void construct() {
        int current, maxChildIndex;
        boolean done;

        for (int i = heap.length / 2 - 1; i >= 0; i--) {

            current = i;
            done = false;

            while (!done) {

                if (2 * current + 1 > heap.length - 1) {
                    //if the current node has no child, so stop
                    done = true;
                } else {

                    //the current node has at least one child, 
                    //get the index of larger child
                    maxChildIndex = maxChild(current, heap.length - 1);
                    if (heap[current] < heap[maxChildIndex]) {
                        count++;

                        //The child is bigger than the node , so swap them and continue      
                        swap(current, maxChildIndex);
                        current = maxChildIndex;
                    } else {
                        count++;
                        done = true;
                    }
                }
            }
        }
    }

    public static void extract() {
        int current, maxChildIndex;
        boolean done;

        for (int size = heap.length - 1; size >= 0; size--) {
            //remove the root node data
            sortedList[size] = heap[0];

            //move the last node to the root
            heap[0] = heap[size];

            //rebuild the heap with one less element           
            current = 0;
            done = false;

            while (!done) {
                //current node has no child, so stop
                if (2 * current + 1 > size) {
                    done = true;
                } else {
                    //the current node has at least one child, 
                    //get the index of larger child
                    maxChildIndex = maxChild(current, size);
                    if (heap[current] < heap[maxChildIndex]) {

                        count++;
                        //a child is larger, so swap and continue       
                        swap(current, maxChildIndex);
                        current = maxChildIndex;
                    } else {
                        count++;
                        done = true;
                    }
                }
            }
        }
    }

    //This method is use for get the index of larger child
    public static int maxChild(int current, int size) {
        int num1;
        num1 = 0;
        for (int i = current; i <= size; i++) {
            if (num1 < heap[i]) {
                num1 = i;
            }
        }
        int left = current * 2 + 1;
        int right = current * 2 + 2;
        if (left <= size && right <= size && heap[left] > heap[right]) {
            return left;
        } else if (left <= size && right <= size && heap[left] < heap[right]) {
            return right;
        } else {
            return left;
        }
    }

    //This method is use for swap two number in the array
    public static void swap(int current, int maxchuilIndex) {
        int temp = heap[current];
        heap[current] = heap[maxchuilIndex];
        heap[maxchuilIndex] = temp;
    }

}
