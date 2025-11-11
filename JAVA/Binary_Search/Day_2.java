import javax.swing.plaf.synth.SynthPasswordFieldUI;

public class Day_2 {
    public static int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[low] <= nums[high]) {
                ans = Math.min(ans, nums[low]);
                break;
            }
            if (nums[low] <= nums[mid]) {
                ans = Math.min(nums[low], ans);
                low = mid + 1;
            } else {
                high = mid - 1;
                ans = Math.min(nums[mid], ans);
            }
        }
        return ans;
    }

    public static int findMinII(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                high--; // skip duplicate
            }
        }
        return nums[low];
    }

    //solved
    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 3,3,1, 2 ,3,3};
        System.out.println(findMinII(arr));
        int k = 2;

        for(int i = -k;i<=k;i++){
            System.out.print(i+" ");
        }
        //nothing has been done
        //today also nothing has been done
        //today also nothing has been done
        //today also nothing has been done
        //today also nothing has been done
        //today also nothing has been done
        //today also nothing has been done
        //today also nothing has been done
        //today also nothing has been done
        //today also nothing has been done
        //today also nothing has been done
        //today also nothing has been done
        //today also nothing has been done
        //today also nothing has been done
        //today also nothing has been done
        //today also nothing has been done
        //today also nothing has been done
        //today also nothing has been done
        //today also nothing has been done
        //today also nothing has been done
        //today also nothing has been done
        //today also nothing has been done
    }

}
