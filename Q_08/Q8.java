
import java.util.*;


public class Q8 {
    public static void main(String args[]){
        int[] numbers = new int[]{87, 44, 99, 167, 36, 67, 94167, 9467};
        Arrays.sort(numbers);        
        System.out.println(show(numbers));
        binarySearch(94167, numbers);
    }
        
    public static void binarySearch(int search, int[] numbers){
        int a = binarySearch(search, numbers, 0, numbers.length-1);
        if(a==-1){
            System.out.println("The number not found");
        }else{
            System.out.println("The number "+search+" is in index "+a);
        }
    }
    //This method use the recursive to build the binary search
    public static int binarySearch(int search, int[] numbers, int begin, int end){
        
        int mid = (begin + end)/2;
        
        if(begin>end){
            return -1;
        }
        
        if(search < numbers[mid]){
            return binarySearch(search, numbers, begin, mid-1);
        }else if(search > numbers[mid]){
            return binarySearch(search, numbers, mid+1, end);
        }else{
            return mid;
        }
        
        
    }
    public static String show(int[] numbers){
        String s = "[";
        for(int i = 0;i<numbers.length;i++){
            if(i==numbers.length-1){
                s += numbers[i];
            }else{
                s += numbers[i]+", ";
            }
        }
        s += "]";
        return s;
    }
   
    

    
}
