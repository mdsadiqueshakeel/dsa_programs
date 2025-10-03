import java.util.*;
public class Day_12 {
    public static List<List<Integer>> three_sum_opt(int arr[]){
        Arrays.sort(arr);
        List<List<Integer>> answer = new ArrayList<>();        
        for (int i = 0; i < arr.length-2; i++){
            if(i > 0 && arr[i] == arr[i-1]){
                continue;
            }
            int j = i+1;
            int k = arr.length -1;
            while(j <k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum < 0){
                    j ++;
                }
                else if(sum > 0){
                    k --;
                }
                else{
                    answer.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    while(j < k && arr[j] == arr[j-1]){
                        j++;
                    }
                    while(j < k && arr[k] == arr[k+1]){
                        k--;
                    }
                }
            }   
        }
        return answer;
    }


    public static void main(String[] args) {
        int [] arr= {-1,0,1,2,-1,-4};
        List<List<Integer>> res = three_sum_opt(arr);
        System.out.println(res);

    }
}
