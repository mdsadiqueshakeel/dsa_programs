package Sliding_Window;

public class Easy {
 public static int Constant_Window(int[] arr, int k) {
    if (k > arr.length) return -1;

    int sum = 0;
    for (int i = 0; i < k; i++) {
        sum += arr[i];
    }

    int max = sum;
    for (int i = k; i < arr.length; i++) {
        sum += arr[i] - arr[i - k]; // slide window
        max = Math.max(max, sum);
    }

    return max;
}


    public static void main(String[] args) {
        int arr[] = {-1,2,3,3,6,8,9,-1,-4};
        System.out.println(Constant_Window(arr, 4));
    }
}
