public class Day_4 {
    public static int Max_length(int arr[], int k){
        int max_len = 0;
        int right = 0;
        int left = 0;
        int n = arr.length-1;
        int sum = arr[0];

        while (right < n){
            while(left <= right && sum > k){
                sum -= arr[left];
                left++;
            }
            if(sum == k){
                max_len = Math.max(max_len, (right - left)+1);
            }
            right++;
            if( right < n){
                sum += arr[right];
            }
        }

        return max_len;
    }

    public static void main(String[] args) {
        int arr [] = {1,2,3,1,1,1,1,3,3};
        System.out.println(Max_length(arr, 9));

    }
}
