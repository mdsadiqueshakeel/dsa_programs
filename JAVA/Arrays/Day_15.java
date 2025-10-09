import java.util.*;

public class Day_15{

    public static List<Integer> findErrorNums(int arr[]){
        long n = arr.length;
        long sn = (n*(n+1))/2;
        long sn2 = (n*(n+1)*(2*n+1))/6;
        long s = 0;
        long s2 = 0;
        for(int nums:arr){
            s += (long)nums;
            s2 += (long)nums * (long)nums;
        }
        long val1 = s-sn;
        long val2 = s2 - sn2;
        val2 = val2/val1;
        long x = (val1 + val2)/2;
        long y = x - val1;
        return Arrays.asList((int) x, (int) y);
    }
    public static void main(String[] args) {
        int nums[] = {1,2,2,4};
        System.out.println(findErrorNums(nums));

    }
}