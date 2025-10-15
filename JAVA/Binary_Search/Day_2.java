public class Day_2 {
    public static int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length -1;
        while (low <= high){
            int mid = (low+high)/2;
            if(nums[low] <= nums[high]){
                ans = Math.min(ans,nums[low]);
                break;
            }
            if(nums[low] <= nums[mid]){
                ans = Math.min(nums[low],ans);
                low = mid+1;
            }
            else{
                high = mid-1;
                ans = Math.min(nums[mid],ans);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {3,4,5,1,2};
        System.out.println(findMin(arr));
    }
} 
