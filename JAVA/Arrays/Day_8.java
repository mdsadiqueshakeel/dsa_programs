import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Gatherer.Integrator;

public class Day_8 {

    // Q1. Leaders Array
    public static ArrayList<Integer>  Leaders_Array(int[] arr){
        int maxi = Integer.MIN_VALUE;
        ArrayList <Integer> ans = new ArrayList<>();
        for(int i = arr.length-1; i >= 0;i--){
            if(arr[i] > maxi){
                ans.add( arr[i]);
            }
            maxi = Math.max(maxi, arr[i]);
        }
        return ans;
    }

    // Q2. Longest Consecutive element
    public static int Longest_Consecutive_Opt(int [] arr){
        int n = arr.length;
        int Longest = 0;
        HashSet<Integer> newSet = new HashSet<>();
        if (n ==0){
            return 0;
        }
        for (int el: arr){
            newSet.add(el);
        }
        
        for (int it : newSet){
            if(!newSet.contains(it -1)){
                int cnt = 1;
                int x = it;
                while(newSet.contains(x+1)){
                    cnt++;
                    x++;
                }
                Longest = Math.max(cnt, Longest);
            }
        }

        return Longest;

    }

    public static void print(ArrayList<Integer> arr){
      for(int i = 0; i < arr.size(); i++){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int [] arr = {10,22,12,3,0,6};
        print(Leaders_Array(arr));

        int [] arr2 = {102,4,100,1,101,3,2,1};
        System.out.println(Longest_Consecutive_Opt(arr2));


    }
}
