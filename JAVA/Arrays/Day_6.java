import java.util.HashMap;
import java.util.Map;

public class Day_6 {

    // Q1. majority element (N/2 times) _(Better) <----- Nested Loop can be brute approcah ------>
    public static int Majority_Element(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: arr) {
            if (map.containsKey(num)) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > arr.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    // Q1. majority element (N/2 times) _(Optimal)
    public static int Majority_Element_Opt(int[] arr){
        int count =0;
        int element = -1;
        for (int num: arr){
            if(count == 0){
                count =1;
                element = num;
            }
            else if(num == element){
                count++;
            }
            else{
                count--;
            }
        }

        int counter =0;
        for(int num:arr){
            if(element == num){
                counter++;
            }
        }
        if(counter > (arr.length/2)){
            return element;
        }

        return -1;
    }
    // Q2. Maximum Subarray Sum (Better)
    public static int Maximum_subArray_Sum(int[] arr){
        int maxi =0;
        for(int i = 0;i<arr.length; i++){
            int sum = 0;
            for(int j = i+1;j<arr.length; j++){
                sum += arr[j];
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
    }

    // Q2. Maximum Subarray Sum (Optimal) <<------ Kadane's Algorithm ------>>
    public static int Maximum_subArray_Sum_Opt(int[] arr){
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            if(sum < 0){
                sum = 0;
            }else{
                sum += arr[i];
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 3, 3, 2, 3, 3, 3, 3, 2, 1 };

        System.out.println(Majority_Element_Opt(arr));

        int[] max_arr = {-2,-3,4,-1,-2,1,5,-3};
        System.out.println(Maximum_subArray_Sum_Opt(max_arr));
    }
}