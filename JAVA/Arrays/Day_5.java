import java.util.HashMap;

public class Day_5{
    // Q1. Two Sum 

    public static int[] Two_sum(int[] arr, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int value = arr[i];
            int remain = target - value;
            if(map.containsKey(remain)){
                return new int[]{map.get(remain), i};
            }
            map.put(value, i);

        }
        return new int[]{};
    }

    //Q2. Sort an Array of 0s, 1s and 2s (Better) -----> Brute was the merge sort <------
    public static int[] Sort_ZOT_Better(int[] arr){
        int count0 =0;
        int count1 =0;
        int count2 =0;
        for(int i = 0; i < arr.length; i++){
            if( arr[i] == 0){
                count0++;
            }
            else if(arr[i]==1){
                count1++;
            }else{
                count2++;
            }
        }

        for(int i =0; i < count0; i++){
            arr[i]= 0;
        }
        for(int i =count0 ; i < count0 + count1; i++){
            arr[i]= 1;
        }
        for(int i =count0 + count1; i < arr.length; i++){
            arr[i]= 2;
        }

        return arr;
    }

    //Q2. Sort an Array of 0s, 1s and 2s (Optimal) <<---- Dutch National Algorithm ---->>
    public static int[] DNF_Algo(int[] arr){
        int low = 0;
        int mid = 0;
        int high = arr.length -1;
        while(mid < high){
            if(arr[mid] == 0){
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            }
            if(arr[mid] == 1){
                mid++;
            }
            if(arr[mid] == 2){
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high --;
            }
        }
        return arr;
    }

    public static void print(int arr[]){
      for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,6,1,2,8,10};
        int target = 14;
        print(Two_sum(arr, target));

        int[] zot_arr = {0,1,2,0,2,0,1,0,2,1,2,1,1};
        print(Sort_ZOT_Better(zot_arr));   // TC- O(2N) SC- O(1)
        print(DNF_Algo(zot_arr)); // TC- O(N) SC- O(1)

    }
}