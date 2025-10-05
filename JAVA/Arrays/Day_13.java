import java.util.*;
public class Day_13 {
    public static List<List<Integer>> Four_sum_opt(int[] arr,int target){
        Arrays.sort(arr);
        List<List<Integer>> answer = new ArrayList<>();        
        for (int i = 0; i < arr.length-2; i++){
            if(i > 0 && arr[i] == arr[i-1]){
                continue;
            }
            for (int  j = i+1; j < arr.length-2; j++){
                if(j != i+1 && arr[j] == arr[j-1]){
                    continue;
                }
                int k = j+1;
                int l = arr.length -1;
                while(k < l){
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if(sum < target){
                        k ++;
                    }
                    else if(sum > target){
                        l --;
                    }
                    else{
                        answer.add(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                        k++;
                        l--;
                        while(k < l && arr[k] == arr[k-1]){
                            k++;
                        }
                        while(k < l && arr[l] == arr[l+1]){
                            l--;
                        }
                    }
                }
            }       
        }
        return answer;
    }
    public static void main(String[] args) {
        int [] nums = {1,0,-1,0,-2,2};
        System.out.println(Four_sum_opt(nums,0));
    }
}
