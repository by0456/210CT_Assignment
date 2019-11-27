
public class Q11 {
    public static int count = 0;
    public static void main (String [] args){
        Q11 bS = new Q11();
        int [] sequence = {98, 38, 93, 33, 21, 6, 63, 81, 32};
        System.out.println("The sequence : ");
        bS.show(sequence);
        bS.bubbleSort(sequence);
        System.out.println("The total number of comparisons from both extraction and construction phases : ");
        System.out.println(count);

    }
    
    public void bubbleSort(int [] sequence){
        for(int i=0;i<sequence.length-1;i++){
            for(int k=0;k<sequence.length-1-i;k++){
                count++;
                if(sequence[k] > sequence[k+1]){
                    int temp = sequence[k];
                    sequence[k] = sequence[k+1];
                    sequence[k+1] = temp;
                }
            }
        }
        System.out.println("Bubble Sort :");
        show(sequence);  
    }
    
    public void show(int [] sequence){
        System.out.print("[");
        for(int j=0;j<sequence.length;j++){
            if(j==sequence.length-1){
                System.out.print(sequence[j]);
            }else{
                System.out.print(sequence[j]+", ");
            }
        }
        System.out.println("]");
    }
}
