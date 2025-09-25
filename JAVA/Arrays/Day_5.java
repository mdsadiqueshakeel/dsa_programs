import java.util.HashMap;

public class Day_5{

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
    }
}