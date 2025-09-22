import java.util.ArrayList;

public class Lec_2 {

    // Q1. Left Rotated array by one places
    public static int[] reverseArrayByOnPlace(int arr[]){
        int temp = arr[0];
        for(int i = 1; i < arr.length; i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;

        return arr;
    }

    // Q2. Left Rotated array by k places (Brute)
    public static int[] reverseArrayBy_N_Places(int arr[], int k){
        int n = arr.length;
        k = k % n;

        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i <= k; i++){
            temp.add(arr[i]);
        }

        for( int i = k; i < n;i++){
            arr[i-k] = arr[i];
        }

        for( int i = 0; i < temp.size()-1;i++){
            arr[(n-k)+i] = temp.get(i);
        }
        return arr;
    } 
    // Q2. Left Rotated array by k places (Optimal)
    public static void reverse(int arr[], int start, int end){
        while(start <end){
            int temp = arr[start];
            arr[start]= arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static int[] Opt_reverseArrayBy_N_Places(int arr[],int  k){
        int n = arr.length;
        k = k % n;
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        reverse(arr,0,n-1);

        return arr;
    }


    public static void print(int arr[]){
      for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        print(Opt_reverseArrayBy_N_Places(arr,5));
        print(reverseArrayByOnPlace(arr));

    }
}
