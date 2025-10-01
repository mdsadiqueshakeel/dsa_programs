import java.util.HashMap;

public class Day_10 {

    public static int SubArray_Sum(int[] arr, int k){
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            int sum = 0;
            for(int j = i ; j < arr.length; j++){
                sum += arr[j];
                if ( sum == k){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int SubArray_Sum_Opt(int[] arr, int k){
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int prefix = 0;
        int cnt = 0;
        mpp.put(0,1);
        for(int i =0 ; i < arr.length; i++){
            prefix += arr[i];
            int remove = prefix -k;
            cnt += mpp.getOrDefault(remove,0);
            mpp.put(prefix, mpp.getOrDefault(prefix,0)+1);
        }

        return cnt;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,-3,1,1,1,4,2,-3};
        System.out.println(SubArray_Sum_Opt(arr,3));
    }
}
