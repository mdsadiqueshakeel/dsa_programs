import java.util.*;
public class printDiv {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        int n = 36;
        for (int i = 1; i < Math.sqrt(n); i ++){
            if(n % i == 0){
                arr.add(i);
                if((n/i)!= i){
                    arr.add(n/i);
                }                
            }

        }
        Collections.sort(arr);
        System.out.println(arr);
    }
    
}
